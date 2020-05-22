ArrayList<Student1> students = new ArrayList<>();

public ArrayList<Student1> searchByKey(String key, int keyInt) {
    ArrayList<Student1> returnStudent = new ArrayList<>();
    Student1 student = new Student1(key);
    students.forEach(element -> {
        if (element.getName().equals(key) && element.getHUN() == keyInt) {
            returnStudent.add(element);
        }
    });
    return returnStudent;
}