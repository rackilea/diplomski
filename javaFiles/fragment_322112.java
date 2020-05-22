try {
                JSONArray jsonArray=new JSONArray();
                JSONObject object1=new JSONObject();
                object1.put("url","myurl");
                object1.put("phone","myphonenumber");
                object1.put("country","mycountry");
                jsonArray.put(object1);

                //adding another object
                JSONObject object2=new JSONObject();
                object2.put("url","anotherurl");
                object2.put("phone","anotherphonenumber");
                object2.put("country","anothercountry");
                jsonArray.put(object2);


            } catch (JSONException e) {
                e.printStackTrace();
            }