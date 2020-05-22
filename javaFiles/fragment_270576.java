@Override
protected void onPostExecute(JSONObject json) { 

    int count = json.getJSONObject("all").getInt("count");
    if(count>0) {   // There are some questions to retrieve

        /*  In this part I just copied what you put in your question, 
            I don't know what your goal is so I can't help much, 
            but you have the logic to do so */

        JSONArray questions = json.getJSONObject("all").getJSONArray("questions");

        for(int i = 0; i < questions.length(); i++) {
            JSONObject question = questions.getJSONObject(i);


        String Subject = question.getString(TAG_QUESTION_SUBJECT);
        String ChosenAnswer = question.getString(TAG_QUESTION_CHOSENANSWER);
        String Content = question.getString(TAG_QUESTION_CONTENT);

        if (pDialog.isShowing()) pDialog.dismiss();
        ListAdapter adapter = new SimpleAdapter(getBaseContext(), questionList,
            R.layout.listelements,
            new String[] { TAG_QUESTION_SUBJECT }, new int[] {
            R.id.Subject,});

        setListAdapter(adapter);

    } else {

        Toast.makeText(ListView.this, "No data found", Toast.LENGTH_SHORT).show();
        finish();    

    }

}