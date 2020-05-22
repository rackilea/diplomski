public class AndroidInternetTxt extends Activity {

    TextView textMsg, textPrompt;
    final String textSource = "http://sites.google.com/site/androidersite/text.txt";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textPrompt = (TextView)findViewById(R.id.textprompt);
        textMsg = (TextView)findViewById(R.id.textmsg);

        textPrompt.setText("Wait...");
        new TheTask().execute("http://sites.google.com/site/androidersite/text.txt");
        }

        private class TheTask extends AsyncTask<String,Void,String>
        {

        protected String doInBackground(String... args)
        {
        URL textUrl;
        String stringText = "";
        try {
            textUrl = new URL(args[0]);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(textUrl.openStream()));
            String StringBuffer;

            while ((StringBuffer = bufferReader.readLine()) != null) {
                stringText += StringBuffer;
            }
            bufferReader.close();

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
         return stringText;
        }
        protected void onPostExecute(String result)
        {
          super.onPostExecute(result); 
          textPrompt.setText(result);
        } 
       }
}