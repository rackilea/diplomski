public class MaxMinGrades{
  public static void main(String[] args){
    double maxGrade = 0.0;
            double minGrade = 100.0;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter as many student grades as you like. Enter a character to stop.");


            while(input.hasNextDouble()) {
            double grades = input.nextDouble();
              if (grades > maxGrade) {
                maxGrade = grades;
              }
              if (minGrade > grades) {
                minGrade = grades;
              }
            }
            System.out.println("The highest grade is: " + maxGrade);
            System.out.println("The lowest grade is: " + minGrade);
  }
}