JSONArray jArray1 = new JSONArray(jsonObject.getJSONArray("test1"));
    JSONArray jArray2 = new JSONArray(jsonObject.getJSONArray("test2"));

 for (int i = 0; i < jArray1 .length(); i++) {
                            JSON jsonObj = new JSON();
                            JSONObject mojObj = jArray1.getJSONObject(i);
                            jsonObj.setIme(mojObj.getString(KEY_NAME));

                        }