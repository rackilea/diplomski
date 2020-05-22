public List<Question> list() throws SQLException {
    List<Question> questions = new ArrayList<Question>();
    // ...

    try {
        // ...

        while (resultSet.next()) {
            Question question = new Question();
            question.setText(resultSet.getString("Question"));
            question.setAnswer(resultSet.getString("Answer"));
            question.setOptionA(resultSet.getString("A"));
            question.setOptionB(resultSet.getString("B"));
            question.setOptionC(resultSet.getString("C"));
            question.setOptionD(resultSet.getString("D"));
            questions.add(question);
        }
    } finally {
        // ...
    }        

    return questions;
}