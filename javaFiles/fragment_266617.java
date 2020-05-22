public class SampleClass extends AsyncTask<String, Void, String> {

@Override
protected void onPreExecute(){
    super.onPreExecute();
}
@Override
protected String doInBackground(String... strings) {
    BufferedReader reader = null;
    String result=null;
    try {
        URL url = new URL(strings[0]);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        Log.d("testhtt2", "test");
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        Log.d("test44", sb.toString());
        result= sb.toString();

    } catch (Exception e) {
        e.printStackTrace();
        result= null;

    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                result= null;

            }
        }
        return result;
    }
}

@Override
protected void onPostExecute(String s){
    try {
        JSONArray ar =new JSONArray(s);
        for (int i = 0; i < ar.length(); i++){
            JSONObject jsonObject=ar.getJSONObject(i);
            Flowers flowers= new Flowers();
            flowers.setName(jsonObject.getString("NAME"));
            flowersList.add(flowers);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
  }
}