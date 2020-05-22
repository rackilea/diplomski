public class BackgroundTask extends AsyncTask<String, Void, String> {

    protected void onPreExecute(){}

    protected String doInBackground(String... arg0) {

      try {

        URL url = new URL("https://disjunct-swabs.000webhostapp.com/testapp.php"); 

        JSONObject postDataParams = new JSONObject();
        postDataParams.put("id", "0");
        postDataParams.put("balance", "666");
        Log.e("params",postDataParams.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(15000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

         OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();

            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in=new BufferedReader(new
                       InputStreamReader(
                              conn.getInputStream()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();

            }
            else {
                return new String("false : "+responseCode);
            }
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }

    }

    @Override
    protected void onPostExecute(String result) {
       Toast.makeText(getApplicationContext(), result,
                Toast.LENGTH_LONG).show();
    }
}

public String getPostDataString(JSONObject params) throws Exception {

    StringBuilder result = new StringBuilder();
    boolean first = true;

    Iterator<String> itr = params.keys();

    while(itr.hasNext()){

        String key= itr.next();
        Object value = params.get(key);

        if (first)
            first = false;
        else
            result.append("&");

        result.append(URLEncoder.encode(key, "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(value.toString(), "UTF-8"));

    }
    return result.toString();
}