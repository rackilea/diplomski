public static double obtainGrade(int students){
    Scanner input = new Scanner(System.in);

        System.out.println("Enter Grade");
        //sets grade to input wiping all previous inputs
        grade = input.nextInt();
        //adds grade to itself again
        grade+=grade;

    return grade;
}