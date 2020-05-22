String questions[] = {
    "What planet has the largest rings? \n\nA. Neptune \nB. Saturn \nC. Jupiter",
    "What planet has a large redspot? \n\nA. Neptune \nB. Saturn \nC. Jupiter",
    "What planet is farthest from the sun? \n\nA. Neptune \nB. Saturn \nC. Jupiter"
};
String rightAnswer[] = { "B", "C", "A" };
String answer = null; // the user's answer
for (int i = 0; i < questions.length; i++) {
    do {
        answer = JOptionPane.showInputDialog(questions[i]);
    } while (!(answer.equals("A")|| answer.equals("B") || answer.equals("C")));
    String x = (answer.equals(rightAnswer[i])) ? "correct" : "incorrect.\nThe correct answer was " + rightAnswer[i];
    JOptionPane.showMessageDialog(null, "Your answer was " + x + ".");
}