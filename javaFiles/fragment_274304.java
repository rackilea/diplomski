for (int i = 1; i < 6; i++) {
    String grade = "";
    System.out.println("Please enter the grade for course " + i);
    char c;
    while((c = (char) System.in.read()) != '\n') {
        grade += c;
    }
    System.out.println(grade);
}