@Override
    public void onResponse(JSONObject response) {

            try {
               JSONObject json = new JSONObject(response); 
               JSONObject json_embedded = json.getJSONObject("_embedded");// need to access JSONObject("_embedded")
               JSONArray jsonArray = json_embedded.getJSONArray("customers"); // then get JSONARRAY
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject customer = jsonArray.getJSONObject(i);
                    emailList.add(customer.getString("email"));
                    passwordList.add(customer.getString("password"));
                }

            } catch (Exception e) {
               e.printStackTrace();
            }
    }