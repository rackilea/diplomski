public static void main(String[] args) throws IOException {
    File gameFile = new File("trivia.txt");
    List<TriviaQuestion> triviaQuestions = new ArrayList<TriviaQuestion>();
    Scanner infile = new Scanner(gameFile);
    String lastKnownCategory = "";

    while (infile.hasNextLine()) {
        String currentLine = infile.nextLine();

        if (!currentLine.isEmpty()) {
            TriviaQuestion currentQuestion = new TriviaQuestion();

            if (currentLine.endsWith("?")) {
                currentQuestion.category = lastKnownCategory;
                currentQuestion.question = currentLine;
                currentQuestion.answer = infile.nextLine();
            } else {
                currentQuestion.category = currentLine;
                currentQuestion.question = infile.nextLine();
                currentQuestion.answer = infile.nextLine();
                lastKnownCategory = currentLine;
            }
            triviaQuestions.add(currentQuestion);
        }
    }
}