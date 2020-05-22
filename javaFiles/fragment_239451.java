List<JSONObject> jsobj = new ArrayList<JSONObject>();

            jsobj = CommanClass.ParseObject_RecieptMaster
                    .getList(MainScreen.key_ingredientlist);

            for (int i = 0; i < jsobj.size(); i++) {
                Log.e("in the For loop ", ": : ::111111 : " + jsobj.get(i));

                JSONObject arr1 = new JSONObject((Map) jsobj.get(i)); // jsobj.get(i);
                Log.e("in the For loop ", ": : ::111111 : " + arr1);
                try {
                    Log.e("in the For loop ",
                            ": : ::111111 : " + arr1.getString("name"));

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }