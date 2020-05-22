try {
            JSONArray jArray = new JSONArray(responseString);
            int size= jArray.length();
            for (int i = 0; i < size; i++) {
                JSONObject item= jArray.getJSONObject(i);
                System.out.println("id : " + item.getString("id"));
                System.out.println("itemname : " + item.getString("itemname"));
                System.out.println("itemdescription : " + item.getString("itemdescription"));

                    // ........ so on 

            }
        } catch (Exception e) {
        }