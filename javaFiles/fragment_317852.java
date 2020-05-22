protected void sendJson(final String email, final String pwd) {

                HttpClient client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                HttpResponse response;
                JSONObject json = new JSONObject();
                try{
                    HttpPost post = new HttpPost(URL);
                    json.put("email", email);
                    json.put("password", pwd);
                    StringEntity se = new StringEntity( "JSON: " + json.toString());  
                    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    post.setEntity(se);
                    response = client.execute(post);
                    /*Checking response */
                    if(response!=null){
                        InputStream in = response.getEntity().getContent(); //Get the data in the entity

                }
                catch(Exception e){
                    e.printStackTrace();
                    createDialog("Error", "Cannot Estabilish Connection");
                }

           }