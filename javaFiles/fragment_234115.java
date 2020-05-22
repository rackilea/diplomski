Boolean canClick = true; //make global variable
public void onClick(View v) {
        if(canClick){

          new DownloadImageTask().execute();
        }
    }

        private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {


            protected Bitmap doInBackground(String... urls) {
                 Log.d("MSG","Clicked");
                 canClick =false;
                 //perform your long operation here

                return null;
             }

             protected void onPostExecute(Bitmap result) {
                 canClick =true;
             }
         }