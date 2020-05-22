public Student getStudent(Map<String, School> schoolMap, String schoolId, String studentId)
{
    return Optional.ofNullable(schoolId)             // schoolId might be null
          .map(id -> Stream.of(schoolMap.get(id)))   // get Stream<School> by  else
          .orElse(schoolMap.values().stream())       // ... get Stream of all Schools
          .flatMap(i -> i.getStudentIdToStudentMap() // students from 1/all schools ...
                         .entrySet().stream())       // flat map to Stream<Entry<..,..>>
          .collect(Collectors.toMap(                 // collect all entries bu key/value
              Entry::getKey, Entry::getValue))       // ... Map<String,Student> 
          .getOrDefault(studentId, null);            // get Student by id or else null
}