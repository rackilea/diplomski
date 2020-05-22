String regex = "[0-9\\(\\)]+\\.\\s(.*?)[0-9\\(\\)]+\\.\\s";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(wholeFileAsString);
    ArrayList<String> allQuestions = new ArrayList<String>();
    while (m.find()) {
        allQuestions.add(m.group(1));
    }
    System.out.println("Total Questions : "+allQuestions.size());
    for (String QuestionString : allQuestions) {
        String regex2 = "\\s[a-zA-Z]\\.\\s";
        String splits[] = QuestionString.split(regex2);
        String questionSt = splits[0];
        String rightAnswer = splits[1];
        String wrongAnswer1 = splits[2];
        String wrongAnswer2 = splits[3];
        String wrongAnswer3 = splits[4];
        Question question=new Question();
        question.setQuestion(questionSt);
        question.setRightAnswer(rightAnswer);
        question.addWrongAnswer(wrongAnswer1);
        question.addWrongAnswer(wrongAnswer2);
        question.addWrongAnswer(wrongAnswer3);
        System.out.println(question.toString());
    }