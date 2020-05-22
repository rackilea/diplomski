public class MainActivity extends Activity
{   
@Override
protected void onCreate(Bundle savedInstanceState) 
{
    .... // Some code here
    // Async task can also be called from within an onclick code.
    new AsyncTaskOperation().execute("");
}


/* Async Task called to avoid Android Network On Main Thread Exception. Web services need to be consumed only in background.     */
private class AsyncTaskOperation extends AsyncTask <String, Void, Void>
{

    private ProgressDialog Dialog = new ProgressDialog(LoginActivity.this);
     String ciao="";
    protected void onPreExecute() {
        // Display the loading spinner
        Dialog.setMessage("Loading... Please wait.. ");
        Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        Dialog.setInverseBackgroundForced(false);
        Dialog.setCancelable(false);
        Dialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar_new));

        Dialog.show();
    }

    @Override
    protected Void doInBackground(String... paramsObj) {
       HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(
            "http://www.masterkool.com/callcenter/index.php");
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    nameValuePairs.add(new BasicNameValuePair("a_user", user.getText()
            .toString()));
    nameValuePairs.add(new BasicNameValuePair("a_pass", pass.getText()
            .toString()));

    try {

        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse execute = httpclient.execute(httppost);
        InputStream content;
        content = execute.getEntity().getContent();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(
                content));
        String s = "";
        String test = "";
        while ((s = buffer.readLine()) != null) {
            test += s;
        }
        if (test.contains("U")) {
            // reset field and toast
            Toast.makeText(getBaseContext(), "Login Failed",     Toast.LENGTH_SHORT)
                    .show();
        } else {
            // Intent intent = new Intent(MainActivity.this,Form.class);
            // this.startActivity(intent);
            Toast.makeText(getBaseContext(), "Login Successful",
                    Toast.LENGTH_SHORT).show();
        }
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return null;
    }

    protected void onPostExecute(Void unused) 
    {
        // Close progress dialog
        Dialog.dismiss();
        // Do actions after end of the HTTPGet or POST Method

    } // End of method onPostExecute

} // End of class AsyncTaskOperation

} End of MainActivity