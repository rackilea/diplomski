public class RequesTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... params) {
                // TODO Auto-generated method stub

                HttpRequestManager mHttpRequestManager new HttpRequestManager();
                String returnValue = mHttpRequestManager.RegisterUser()

                return returnValue;
        }

        @Override
        protected void onPostExecute(String result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);

                //your result here

        }
}