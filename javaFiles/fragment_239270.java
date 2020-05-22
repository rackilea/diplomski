public static void displayArray(Student[] students){

    for (Student s : students) {
        System.out.println(String.format("Name = %s, id = %d", s.getName(), s.getIdNumber());
    }
}//end method