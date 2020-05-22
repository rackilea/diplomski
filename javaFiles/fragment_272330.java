public class GetPNR extends AsyncTask<String, Integer, String> {


    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        String al_texts = "";

        for(String newUrl:params){
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(newUrl);
            HttpResponse response;
            try {
                response = client.execute(get);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String webData = "";

                while((webData = reader.readLine()) != null){
                     Log.i("data", webData);
                     JSONObject myAwway = new JSONObject(webData);

                    JSONObject data = myAwway.getJSONObject("data");
                    Log.i("data", data.toString());
                    JSONObject travelDate = data.getJSONObject("travel_date");
                    JSONObject from = data.getJSONObject("from");
                    JSONObject to = data.getJSONObject("to");
                    JSONObject alright = data.getJSONObject("alight");
                    JSONObject board = data.getJSONObject("board");
                    JSONArray passenger = data.getJSONArray("passenger");

                    al_texts = data.getString("train_name");
                    Log.i("data", al_texts);
                }
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return al_texts;

    }
}