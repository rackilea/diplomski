void method1(ArrayList<RegistrationSystem> listOfRegistrationSystems) {
    listOfRegistrationSystems.add(new Course()); 
}
void method2() {
    ArrayList<Student> listOfStudents = new ArrayList<>();
    method1(listOfStudents);
    Student student = listOfStudents.get(0);
    // Ooops! The first element of listOfStudents is not a Student!
}