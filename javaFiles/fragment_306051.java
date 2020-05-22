// A - first instantiation of badAnswers list
    List<String> badAnswers = new LinkedList<>();
    for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {

        switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                break;

            case XMLStreamConstants.END_ELEMENT:
                if (parser.getLocalName().equals("questionReponse")) {
                    Question question = new Question(currentCategory, currentQuestion, currentRightAnswer, badAnswers);
                    quiz.add(question);
                    // B - Renew badAnswers after each Question entry insert
                    badAnswers = new LinkedList<>();    
                }