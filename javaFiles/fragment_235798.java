public static void main(String[] args) {
    Student tom = new Student();
    tom.name = "Tom";
    tom.id = 1;
    tom.age = 15;
    tom.year = 10;
    printDetails(tom);
}

private static void printDetails(Student student) {
    System.out.println(student.name);
    System.out.println(student.id);
    System.out.println(student.age);
    System.out.println(student.year);
}