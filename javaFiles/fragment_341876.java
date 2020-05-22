import java.util.Scanner;

class Main{
  public static void main(String[] args) {
    //Initialize scanner object
    Scanner scanner = new Scanner(System.in);

    //Prompt user for input
    System.out.print("Enter a Set of Grades:");
    String store = scanner.nextLine();

    //Remove all white space and round brackets
    store = store.replaceAll("[\\(\\)\\s+]","");

    //Split input into individual grades
    String[] grades = store.split(";");

    double sum = 0;
    //Loop over each entered grade and add to sum variable
    for (String grade : grades) {
      if(grade.contains("/")) {
        double numerator = Double.parseDouble(grade.split("/")[0]);
        double denominator = Double.parseDouble(grade.split("/")[1]);
        sum += numerator/denominator * 100;
      } else {
        sum += Double.parseDouble(grade);
      }
    }

    System.out.printf("The average is: %.2f\n", sum/grades.length);
  }
}