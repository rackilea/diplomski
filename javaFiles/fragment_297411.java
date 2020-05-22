private SharedPreferences sharedPreference;
 sharedPreference=context.getApplicationContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE);

public void saveQuestionOptionResponse(String response) {

        sharedPreference.edit().putString("Question", response);
        sharedPreference.edit().commit();
    }

public QuestionOptionModel getQuestionOption() {
        Gson gson = new Gson();
        String json = sharedPreference.getString("Question", "");
        QuestionOptionModel model = gson.fromJson(json, QuestionOptionModel.class);
        return response;
    }