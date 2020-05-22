public static int totalGrade

public static double obtainGrade(int students){
    Scanner input = new Scanner(System.in);

        System.out.println("Enter Grade");
        grade = input.nextInt();
        totalGrade+=grade;

    return grade;
}

avg = totalGrade/students;