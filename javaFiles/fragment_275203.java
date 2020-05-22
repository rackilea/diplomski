new Thread(new Runnable() {
        @Override
        public void run() {

            try {

                URL url = new URL("https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJN1t_tDeuEmsRUsoyG83frY4&key=AIzaSyAAkK3AyE8Cbqb9H5MYqptjJwRhRgltoZM");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();

                int ch = -1;
                StringBuffer buffer = new StringBuffer();
                while((ch = in.read()) != -1){
                    buffer.append((char)ch);
                }

                JSONObject jObj = new JSONObject(buffer.toString());
                JSONObject jResult = jObj.getJSONObject("result");
                JSONArray jReviewArray = jResult.getJSONArray("reviews");

                for(int i=0; i<jReviewArray.length(); i++){
                    JSONObject jReview = jReviewArray.getJSONObject(i);
                    System.out.println( jReview.getString("author_name") +"\n"+ jReview.getString("text") +"\n\n");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }).start();