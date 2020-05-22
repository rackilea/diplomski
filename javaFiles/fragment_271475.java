List<String> filteredNames = new ArrayList<>();

for(Student student : listStudents) {

    if(student.isFulltime()) {
        filteredNames.add(student.getName());
    }

}