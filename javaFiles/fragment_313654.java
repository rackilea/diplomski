public class Find2Max {

  public void run() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter the number of students (at least 2 required for comparison): ");
    int number_of_students = sc.nextInt();

    if(number_of_students < 2){
      System.out.println("\nThis program compares scores for 2 or more students.");
      // number_of_students = 2;
      return;
    }

    do{

      double top_grade = 0;
      double second_top_grade = 0;
      String top_kid = "";
      String second_top_kid= "";

      for(int ii = 0; ii < number_of_students; ii++){
        System.out.print("\nEnter a student name: ");
        String student_name = sc.next();

        System.out.print("Enter a student score: ");
        Double student_grade = sc.nextDouble();

        if(student_grade >= top_grade){
          if(top_grade >= second_top_grade) { // Save this grade as the second top
            second_top_kid = top_kid;
            second_top_grade = top_grade;
          }
          top_kid = student_name;
          top_grade = student_grade;
        }
        else if(student_grade > second_top_grade && student_grade < top_grade){
          second_top_grade = student_grade;
          second_top_kid = student_name;
        }
//        else{
//          student_grade = 0.00;
//          student_name ="";
//        }
      }
      System.out.println("\nTop two students: ");
      System.out.println( top_kid + "'s score is " + top_grade);
      System.out.println(second_top_kid + "'s score is " + second_top_grade);
    }while(number_of_students >= 2);
  }

  public static void main(String[] args){
    Find2Max test = new Find2Max();
    test.run();
  }
}