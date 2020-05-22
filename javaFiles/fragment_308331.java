private class GetImages extends AsyncTask<String, Integer, ArrayList<String>>{
   ArrayList<String> list = new ArrayList<String>();
    @Override
    protected ArrayList<String> doInBackground(String... params) {
        try {

        HttpClient defaultClient = new DefaultHttpClient();
        HttpGet httpGetRequest = new HttpGet("http://api.apps.com/category_item/get_image/" + itemId);
        HttpResponse httpResponse = defaultClient.execute(httpGetRequest);

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String returnValues = "";

        while((returnValues = reader .readLine()) != null){
          JSONArray arr = new JSONArray(returnValues);

        //Define this list globally ,so you can use it any where of this class after adding data           
        for(int i = 0; i < arr.length(); i++){
            list.add(arr.getJSONObject(i).getString("image"));
        }
      }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return list;
  }

    @Override
    protected void onPostExecute(ArrayList<String> result) {
        //use this result and put in your textView
    }
}