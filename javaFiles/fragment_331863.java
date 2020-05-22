public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    System.out.print("Ente Employee ID: ");
    int employeeId = s.nextInt();
    System.out.print("Ente SEX: ");
    char SEX = s.next().charAt(0);
    System.out.print("Ente Employee Name: ");
    String employeeName = s.nextLine();
    employeeName = s.nextLine();// Try to add this line of code
    System.out.println("Employee ID is " + employeeId);
    System.out.println("Employee Name is " + employeeName);
    System.out.println("Employee gender is " + SEX);

}