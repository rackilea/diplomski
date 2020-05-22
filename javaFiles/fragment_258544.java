protected String doInBackground(String... args) {
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        // getting JSON string from URL
        String json = jsonParser.makeHttpRequest(url, "GET",
                params);

        // Check your log cat for JSON reponse
        Log.d("Albums JSON: ", "> " + json);

        JSONObject jsonObj = new JSONObject(json);

        try {
            users = jsonObj.getJSONArray("DataUser");

            if (users != null) {
                // looping through All albums

                for (int i = 0; i < users.length(); i++) {
                    JSONObject c = users.getJSONObject(i);
                    Toast.makeText(getBaseContext(),"errrrrrorrrrr",Toast.LENGTH_LONG).show();
                    // Storing each json item values in variable
                    String user_id = c.getString("user_id");
                    String name = c.getString("name");
                    String email = c.getString("email");
                    String display_name = c.getString("display_name");
                    String phone = c.getString("phone");
                    String ym = c.getString("ym");
                    String created_at = c.getString("created_at");
                    String last_login = c.getString("last_login");
                    String updated_at = c.getString("updated_at");
                    // creating new HashMap
                    //HashMap<String, String> map = new HashMap<String, String>();

                    items.add(new ProductClass(Integer.parseInt(user_id), name, email, display_name,phone, ym, created_at, last_login, updated_at));
                }
            }else{
                Log.d("Users: ", "null");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }