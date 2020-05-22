public static void readGrades(){
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the number of grades: ");
    numGrades = input.nextInt();
    grades = new int[numGrades];
}