private class Upload_Data extends AsyncTask<String, String, String>() {
 @Override
            protected String doInBackground(String... params) {
                WebService ws = new WebService(URL);
                Map<String, String> data = new HashMap<String, String>();
                data.put("user_fb_id", userid);
                data.put("first_name", userfirstname);
                data.put("middle_name", userfirstname);
                data.put("gender", gender);
                data.put("email", email);
                data.put("last_name", userfirstname);
                data.put("user_fb_profile_name", name);
                data.put("fb_profile_pic", userimage.toString());


                try {
                    String response = ws.makeHTTPRequest(data, "POST");
                    JSONObject jsonObject = new JSONObject(response);
                    Log.e("Response", jsonObject.toString());

                } catch (Exception e) {
                    Log.d("", "Exception : " + e.getMessage());
                }
                return null;
            }
        }