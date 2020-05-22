public class Compile extends Activity {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            new AsyncTaskOperation().execute();

       }// End of oncreate

        private class AsyncTaskOperation extends AsyncTask <String, Void, Void>
        {
            protected void onPreExecute() { /* Activities before URL call*/ }

            protected void onPreExecute() { /* Activities after URL Call*/ }

            @Override
             protected Void doInBackground(String... paramsObj) {

           //Sending the php file path 
            String php_send="http://localhost/Android/App/copy.php?Coords=allahwariya.mp3";

            // want to execute the above path using Http client but it is not working 
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(php_send);
            try
            {   
                HttpResponse resp = client.execute(httpGet);
                System.out.println(resp);
                 if (httpResponse != null){
                     HttpEntity httpEntity = httpResponse.getEntity();
                      try {
               responseString = EntityUtils.toString(httpEntity);
          } catch (ParseException e) {
            } catch (IOException e) {
            }
                  }// End of if resonse is null
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }


        } // End of class AsyncTaskOperation 


}// End of class compile