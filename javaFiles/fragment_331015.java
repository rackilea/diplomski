public Student getStudent(Map<String, School> schoolMap, String schoolId, String studentId)
{
    return Optional.ofNullable(schoolId)                          // schoolId might be null
           .map(i -> Collections.singletonList(schoolMap.get(i))) // add School into List
           .orElse(new ArrayList<>(schoolMap.values()))           // ... else all schools
           .stream()
           .map(i -> i.getStudentIdToStudentMap()       // get Map of students from 1/all
                      .get(studentId))                  // ... find by studentId
           .filter(Objects::nonNull)                    // get rid of nulls
           .findFirst().orElse(null);                   // get Student by id or else null
}