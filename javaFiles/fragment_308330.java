HttpResponse httpResponse = defaultClient.execute(httpGetRequest);

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
        String returnValues = "";

        while((returnValues = reader .readLine()) != null){
          JSONArray arr = new JSONArray(returnValues);

        //Define this list globally ,so you can use it any where of this class after adding data
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < arr.length(); i++){
            list.add(arr.getJSONObject(i).getString("image"));
        }
      }