public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int studentGrade = keyboard.nextInt();

    while (studentGrade != -1) {
        getLetterGrade(studentGrade);
        studentGrade = keyboard.nextInt();
    }
}