public void filterStudents(Map<Integer, Student> studentsMap){
    Map<Integer, Student> filteredStudentsMap = 
        studentsMap.entrySet()
                   .stream()
                   .filter(s -> s.getValue().getAddress().equalsIgnoreCase("delhi"))
                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}