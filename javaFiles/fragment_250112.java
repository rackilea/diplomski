@Override
public void onResponse(JSONArray response) {
                try{
                    for(int i = 0; i < response.length(); i++) {
                        JSONObject questionObject = response.getJSONObject(i);
                        String question = questionObject.getString("question");
                        questionList.add(question);
                        JSONArray choicesArray = questionObject.getJSONArray("choices");
                        for(int j = 0; j < choicesArray.length(); j++) {
                            JSONObject currentObject = choicesArray.getJSONObject(j);
                            String choice = currentObject.getString("choice");
                            boolean correct = currentObject.getBoolean("correct");
                            choiceList.add(choice);
                            correctList.add(correct);
                        }
                    }
                nextQuestion(index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }