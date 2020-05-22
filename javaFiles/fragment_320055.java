Map<Integer, List<Student>> citiesIdsToStudentsList = new HashMap<>();
for (Student student : students) {
    for (State state : student.getStates()) {
        for (City city : state.getCities()) {
            citiesIdsToStudentsList.computeIfAbsent(city.getId(), k -> new ArrayList<>()).add(student);
        }
    }
}