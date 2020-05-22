public static Student readStudent(Scanner s) throws IOException {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter first name of student");
    String fname = s.nextLine();
    System.out.println("Enter middle name of student");
    String mname = s.nextLine();
    System.out.println("Enter last name of student");
    String lname = s.nextLine();
    System.out.println("Enter name format(1 for ',' and 2 for ';') ");
    int num = s.nextInt();
    s.nextLine(); // Need to consume new line
    System.out.println("Enter age of student");
    int age = s.nextInt();
    s.nextLine(); // Need to consume new line

    // no closing here

    return new Student(new Name(String.join((num == 1) ? "," : ";", fname,
                mname, lname)), age);
}