public class ArrayListBasics {

    private static Scanner input = new Scanner(System.in);
    private static AdjustStudents ad = new AdjustStudents();

    public static void main(String[] args) {

        addNewStudent();

    }

    public static void addNewStudent() {
        System.out.println("----- Adding A New Student -----");

        System.out.println(" Please enter student Name :");
        String name = input.nextLine();
        double gpa = 0;
        System.out.println(" Please enter student GPA :");
        do {
            while (!input.hasNextDouble()){
                System.out.println(" Please enter valid GPA :");
                input.next();
            }
            gpa = input.nextDouble();
        }while (gpa  <= 0);
        ad.addStudent(name, gpa);
    }
}