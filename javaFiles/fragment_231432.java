public void calcGrade() {

    String studentname;
    int mark = 100;   // listing maximum mark
    Scanner inText = new Scanner(System.in);
    System.out.print("Please enter the name of the student >> ");
    studentname = inText.nextLine();
    Scanner inNumber = new Scanner(System.in);
    System.out.print("Please enter mark for student " + studentname + " out of 100 >> ");
    mark = inText.nextInt();
    if(mark <50) System.out.print("The grade for " + studentname + " is F " );
    else if(mark <65) System.out.print("The grade for " + studentname + " is P " );
    else if(mark <75) System.out.print("The grade for " + studentname + " is C " );
    else if(mark <85) System.out.print("The grade for " + studentname + " is D " );
    else System.out.print("The grade for " + studentname + " is HD2" );
}