public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        // Request the name
        System.out.print("What is your name?: ");
        String name = input.nextLine();

        // Create the student object
        Student student = new Student(name);

        // Ask for the grades
        System.out.print("Please enter your scores (q to quit): ");
        String grade = input.nextLine();

        while (!grade.equals("q")) {
            // Convert the grade to an integer and pass it 
           student.addQuiz(Integer.parseInt(grade));
            // Request a new grade
            grade = input.nextLine();
        }

        // Report the results
        System.out.println("Students Name: " + student.getName());
        System.out.println("Total Quiz Scores: " + student.getTotalScore());
        System.out.println("Average Quiz Score: " + student.getAverageScore());
    }

}