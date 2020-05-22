Scanner input = new Scanner(System.in);
String gradeInput;
int grade = -1;

while (grade < 0 || grade > 5) {
    try {
        System.out.print("Enter grade (0-5): ");
        gradeInput = input.nextLine();
        grade = Integer.parseInt(gradeInput);
        if (grade < 0 || grade > 5) {
            System.out.println(gradeInput + " is not a valid grade.");
            System.out.print("\n");
        }
    } catch (NumberFormatException nfe) {   
        System.out.println(gradeInput + " is not a valid grade.");
        System.out.print("\n");
    }
}