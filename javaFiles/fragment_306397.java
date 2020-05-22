public static void main(String[] args) throws Exception {
    String name = JOptionPane.showInputDialog(null,
            "Please enter your name.", "Input Name", JOptionPane.QUESTION_MESSAGE);
    String gradePointString = JOptionPane.showInputDialog(null,
            "What is your grade point average?", "Grade point average", JOptionPane.QUESTION_MESSAGE);
    int gradePoint = Integer.parseInt(gradePointString);
    int x = 10;
    JOptionPane.showConfirmDialog(null,
            "Your name is " + name + ", and your grade point average is " + gradePoint +
            ", so your book store credit is " + (gradePoint*x));
}