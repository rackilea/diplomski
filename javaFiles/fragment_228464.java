private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
     protected String doInBackground(String... urls) {
        URL url = new URL(urls[0]);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.connect();
        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String content = "", line;
        while ((line = rd.readLine()) != null) {
            content += line + "\n";
        }
        return content;
     }

     protected void onProgressUpdate(Integer... progress) {
     }

     protected void onPostExecute(String result) {
         // this is executed on the main thread after the process is over
         // update your UI here
         displayMessage(result);
     }
 }