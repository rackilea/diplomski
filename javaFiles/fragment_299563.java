for (int i = 0; i < questions.length(); i++) {
                                JSONObject obj = questions.getJSONObject(i);
                                MyData data = new MyData(
                                        obj.getString("question_id"),
                                        obj.getString("question_text"));
                                Log.e("Question" + " " + i,
                                        "\nQuestion id = " + data.getQuestionId() +
                                                " Question text = " + data.getQuestionText());
                                dataList.add(data);
                            }
// notify data set change call missing
mAdapter.notifyDataSetChanged();