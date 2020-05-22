new AsyncCaller().execute();

 private class AsyncCaller extends AsyncTask<Void, Void, String>
    {
        ProgressDialog pdLoading = new ProgressDialog(AsyncExample.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("Loading...");
            pdLoading.show();
        }
        @Override
        protected String doInBackground(Void... params) {

           String result= getString("your username","your password")


            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
         pdLoading.dismiss();
        Toast.make(context,result,Toas.LENGTH_SHORT).show();
        }

        }
    }