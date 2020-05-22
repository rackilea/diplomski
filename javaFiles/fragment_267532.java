public void getQA(int id, QuizReceiver callback) throws SQLException {
    try {
        GetQuizService getQuizService = new GetQuizService();
        getQuizService.restart();
        getQuizService.setId(id);
        getQuizService.setOnSucceeded(e -> {
            callback.quizReceived(getQuizService.getValue());
        });         
    } catch (Exception e) {
        System.err.println(e);
    }
    return quiz;
}