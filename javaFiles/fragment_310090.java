public ArrayList<McqQuestionBeanCheck> mcqQuestionParsingCheck(String response) {

    ArrayList<McqQuestionBeanCheck> questions = new ArrayList<McqQuestionBeanCheck>();
    try {
        JSONObject jsonObject = new JSONObject(response);

        JSONArray questionsArray = jsonObject.getJSONArray("details");
        for (int i = 0; i < questionsArray.length(); i++) {
            JSONObject questionObject = questionsArray.getJSONObject(i);
            McqQuestionBeanCheck question = new McqQuestionBeanCheck();
            question.setQuestion_id(questionObject.getInt("question_id"));
            question.setQuestions(questionObject.getString("Questions"));
            question.setMarks(questionObject.getString("Marks"));

            questions.add(question);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
    return questions;
}