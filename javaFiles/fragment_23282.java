public static String[] getPossibleAnswers(Scanner scanner, int possibleAnswers) {
    // Get the possible answers by using the passed in int and scanner...
}

public static Question buildQuestion(Scanner scanner) {
    // Step through the first couple lines building your new question
    // and get q.question and q.possibleAnswers...
    // Now get the possible answers using the helper method
    q.answers = getPossibleAnswers(scanner, q.possibleAnswers);
    // Finish up
    return q;
}

public static ArrayList<Question> createQuestions(String filename) throws IOException {

    ArrayList<Question> questions = new ArrayList<>();

    Scanner fileReader = new Scanner(new File(filename));
    // Every time the reader has a next, it's another question
    while (fileReader.hasNext()) {
        // Here's a question
        questions.add(buildQuestion(fileReader));
    }
    fileReader.close();
    return questions;
}