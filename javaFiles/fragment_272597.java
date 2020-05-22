class MyAsyncTask extends AsyncTask<String, String, String> {

    String LOGIN_URL = "http://www.example.com/someFile.php";
    HttpURLConnection conn;
    DataOutputStream wr;
    StringBuilder result = new StringBuilder();
    URL url;

    @Override
    protected String doInBackground(String... params) {

        try {
            url = new URL(LOGIN_URL);

            conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true); //moved here

            conn.connect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        String cert="name=user_777&message=7656666666";


        try {
            wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(cert);
            wr.flush();
            wr.close();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        conn.disconnect();

        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG ).show();
    }
}