@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_open_dialog);
    final getfromjson parsejson = new getfromjson();
    parsejson.execute();

}

private class getfromjson extends AsyncTask {

    private String dialog = "";
    @Override
    protected Object doInBackground(Object... params) {

        this.parse();
        return this;
    }

    private void parse()
    {

        Gethttp sh = new Gethttp();
        String url = "https://api.myjson.com/bins/1902bf";
        String jsonStr = sh.makeServiceCall(url);
        try {
            JSONObject jsonRoot  = new JSONObject(jsonStr);

            String warningString = jsonRoot.getString("Dialog");
            dialog = warningString;

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public String getDialog()
    {
        return dialog;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        AlertDialog.Builder builder = new AlertDialog.Builder(OpenDialogActivity.this);
        builder.setTitle(getResources().getString(R.string.Message1))
                .setIcon(R.drawable.warning)
                .setMessage(getDialog())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}

public class Gethttp {

    private final String TAG = Gethttp.class.getSimpleName();

    public Gethttp() {
    }

    public String makeServiceCall(String reqUrl) {
        String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}