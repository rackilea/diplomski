public class YourAwesomeGuessingGame extends ... {
    private String currentQuestionKey;

    public YourAwesomeGuessingGame() {
        // Seed the current question key with the first question
        currentQuestionKey = ...;
        // Update the UI

        guessAA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String correctAnswer = myMap.get(key));
                String answerGiven = answerField.getText().toUpperCase();
                // Compare the results, take appropriate action
                // Seed the current question key with the next question
                currentQuestionKey = ...;
                // Update the UI
            }
        }
    }
}