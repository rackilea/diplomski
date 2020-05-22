public static void main(String[] args) {

 boolean flag = false;
 Scanner input = new Scanner(System.in);


 double grade;
 do {
  System.out.println("Enter your grade: ");
  grade = input.nextDouble();
  if (grade <= 100 && grade >= 90) {
   System.out.println("Your grade is an A");
  } else if (grade <= 89 && grade >= 80) {
   System.out.println("Your grade is a B");
  } else if (grade <= 79 && grade >= 70) {
   System.out.println("Your grade is a C");
  } else if (grade <= 69 && grade >= 60) {
   System.out.println("Your grade is a D");
  } else if (grade <= 59) {
   System.out.println("Your grade is an F");
  }

  System.out.println("Do you want to continue (Y/N)?");
  char check = input.next().charAt(0);
  if (check == 'Y') {flag = true;}
  else {flag = false;}
 } while (grade >= 0 && grade <= 100 && flag == true);
}