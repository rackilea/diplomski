ArrayList<String> wrongAnswers = new ArrayList<String>();

// Call this function with the user's answer as a parameter, when the answer
// has been determined to be incorrect.
public void wrongAnswer(String answer) {
    wrongAnswers.add(answer);
}

public void printWrongAnswers() {
    System.out.println("Wrong answers:");
    for (String answer : wrongAnswers) {
        System.out.println(answer);
    }
}