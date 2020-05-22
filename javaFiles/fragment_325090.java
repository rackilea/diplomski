if(response!=null){
            try {

                JSONObject jsonObject = new JSONObject(response);
                JSONObject data = jsonObject.getJSONObject("data");
                JSONArray jsonArray = jsonObject.optJSONArray("applications");
                for(int i=0; i<jsonArray.length(); i++){
                    jsonObject= jsonArray.getJSONObject(i);



                    JSONObject c = jsonArray.getJSONObject(i);

                    String app_name = c.getString("application_name");
                    String app_os = c.getString("application_os");
                    String app_downloads = c.getString("app_downloads");
                    String bundle = c.getString("bundle_id");


                    // playstore node is JSON Object
                    JSONObject playstore = c.getJSONObject("playstore");
                    String downloads = phone.getString("downloads");
                    String rating = phone.getString("rating");
                    String developer = phone.getString("developer");

                    // screenshots node is JSON Array
                    JSONArray screenshots = jsonObject.optJSONArray("screenshots");
                    for(int j=0; j<screenshots.length(); j++){
                        Log.e("screenshot  ",""+screenshots[i]);

                    }

                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }