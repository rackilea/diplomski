public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please input the grade you recieved.");
    double grade = keyboard.nextDouble();
    LetterGrade lg = LetterGrade.fromDouble(grade);
    System.out.println(lg);
}