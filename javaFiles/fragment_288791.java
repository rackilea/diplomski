/*

your code

*/

@Override
protected void onCreate(Bundle savedInstanceState) {

        new MyAsyncTask().execute("");

}

class MyAsyncTask extends AsyncTask<String, String, Void> {

    private ProgressDialog progressDialog = new ProgressDialog(StartScreen.this);
    InputStream inputStream = null;
    String result = "";
    ArrayList<String> list;

    protected void onPreExecute() {
        progressDialog.setTitle("Downloading JSON Data");
        progressDialog.show();
        // above code makes a dialog with a progress bar
    }

    @Override
    protected Void doInBackground(String... params) {
        ArrayList<String> param = new ArrayList<String>();
        URL url, url2;

        try{
            url = new URL("http://dev.regalstreak.me/myjson.json");
            // link to your json file
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setUseCaches(false);
            inputStream = new BufferedInputStream(urlConnection.getInputStream());

        }catch (MalformedURLException malle){
            Log.e("Mal", ""+malle);
            malle.printStackTrace();
        }catch (IOException ioe){
            Log.e("IO", ""+ioe);
            ioe.printStackTrace();
        }

        // Convert response to string using String Builder
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
            StringBuilder sBuilder = new StringBuilder();

            String line = null;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }

            inputStream.close();
            result = sBuilder.toString();

        } catch (Exception e) {
            Log.e("StringBuilding", "Error converting result " + e.toString());
        }
        return null;
    }

    protected void onPostExecute(Void v) {

        //parse JSON data
        try {
            JSONObject jobj = new JSONObject(result);
            //Taking a JSON Array from the JSONObject created above

            String url = jobj.getString("ourUrl");

            // We are adding this string to the ArrayList

            list.add(url);

            progressDialog.dismiss();
            Context con = ListLoader.this.getApplication();
            adapter = new RecyclerAdapter(list,con);

            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            Log.e("JSONException", "Error: " + e.toString());
        } // catch (JSONException e)
    }

}


/*

your code

*/