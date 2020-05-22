System.out.println("Please input the first student info, YES or NO?");
Scanner inText = new Scanner(System.in);
while ("YES".equals(inText.nextLine()) {
    calcGrade();
    System.out.println("Continue input the next student info, YES or NO?");
}