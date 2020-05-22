private class myTask extends AsyncTask<Void,Void,Bitmap>{


      protected Bitmap doInBackground(Void... params) {

            //do stuff
             return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            //do stuff

            }
        }