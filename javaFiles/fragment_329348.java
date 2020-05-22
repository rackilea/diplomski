if(jsonObject.has("categories"))
                {
                    JSONArray jArray = jsonObject.getJSONArray("categories");
 for(int i = 0;i < jArray.length();i++){

                    JSONObject jsonObject1 = jArray.getJSONObject(i);

                    data1 = jsonObject1.getString("name");
                    Log.d("hello ",data1);

                    JSONObject jsonObject2 = jsonObject1.getJSONObject("children");

                    data2 = jsonObject2.getString("name");
                    Log.d("hello2 ",data2);

                    JSONObject jsonObject3 = jsonObject2.getJSONObject("children_lv3");

                    data3 = jsonObject3.getString("name");
                    Log.d("hello3 ",data3);
                    data4 = jsonObject3.getString("href");
                    Log.d("hello4 ",data4);

                    data5=jsonObject2.getString("href");
                    Log.d("hello5 ",data5);
                }
                }