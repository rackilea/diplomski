private static final String TAG_SUCCESS = "success";
private static final String TAG_ANSWER = "answer";
private static final String TAG_BOOL1 = "bool1";
private static final String TAG_BOOL2 = "bool2";
int success;

......
...


                    JSONObject json = jsonParser.makeHttpRequest("xxxxxxxxxxxxxx", "GET", params);

                    // json success tag
                    success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        // successfully received product details
                        JSONArray answerObj = json.getJSONArray(TAG_ANSWER);

                        // get first product object from JSON Array
                        JSONObject answer = answerObj.getJSONObject(0);


                        String bool1s = answer.getString(TAG_BOOL1));
                        String bool2s = answer.getString(TAG_BOOL2));
                        }else{
                        .......
                        ....