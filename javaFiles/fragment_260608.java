private static String url = "address here";
private static final String TAG_CONTENT = "content";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_last_minute);
    TextView tv = (TextView) findViewById(R.id.lastMinuteText);

    // Create progress dialog     
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    // Get the layout inflater
    LayoutInflater inflater = getLayoutInflater();
    // Inflate and set the layout for the dialog
    // Pass null as the parent view because its going in the dialog
    builder.setView(inflater.inflate(R.layout.progressdialog, null));
    progressDialog = builder.create();
    progressDialog.setTitle("Downloading JSON");
    progressDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Whatever",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
    // Show dialog
    progressDialog.show();
    //download json
    new downloadJSON().Execute(url);
}
private class downloadJSON extends AsyncTask<String, Void, String> {

    private String allMessages = "";
    @Override
    protected Void doInBackground(String... params) {
        String url = params;
        //JSON PARSER
        JSONParser jParser = new JSONParser();

        try {
            JSONArray messages = jParser.getJSON(url);
        } catch(JSONException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < messages.length(); i++) {
            JSONObject c;
            try {
                c = messages.getJSONObject(i);
                allMessages = allMessages + c.getString(TAG_CONTENT) + 
                    "\n-----------------------------------------\n";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return allMessages ;
    }

    @Override
    protected void onPostExecute(String result) {
        tv.setText(result);
        progressDialog.cancel();
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }

}