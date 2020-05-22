public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    Student s1 = new Student();
    System.out.print("Enter your name: ");
    s1.name = input.nextLine();
    System.out.print("Enter your id: ");
    s1.id = Integer.parseInt(input.nextLine());
    System.out.print("Enter your gpa: ");
    s1.gpa = Float.parseFloat(input.nextLine());

    Student s2 = new Student();
    System.out.print("Enter your name: ");
    s2.name = input.nextLine();
    System.out.print("Enter your id: ");
    s2.id = Integer.parseInt(input.nextLine());
    System.out.print("Enter your gpa: ");
    s2.gpa = Float.parseFloat(input.nextLine());

    Student s3 = new Student();
    System.out.print("Enter your name: ");
    s3.name = input.nextLine();
    System.out.print("Enter your id: ");
    s3.id = Integer.parseInt(input.nextLine());
    System.out.print("Enter your gpa: ");
    s3.gpa = Float.parseFloat(input.nextLine());

    System.out.println("your name: " + s1.name + "\n" + "your id: " + s1.id + "\n" + "your GPA: " + s1.gpa);

}