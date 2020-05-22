if (newStudents.size() <= 10) { // check the size of the array [see note 1]
    newStudents.add(new Student(firstName, lastName, Major, GPA, UIN, NetId, Age, Gender));
    System.out.println("Student added\n");
} else {
    System.out.println("\n Student interface is full!");
}