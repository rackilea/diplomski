private class LoadingTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute(){
               super.onPreExecute();
               progressDialog.show();
        }

        @Override
        protected String doInBackground(String... str) {
            String response = "";
                    // Call Web Service here and return response

            response = API.getDealsByCategory(str[0], str[1]); 
                    // e.g.: above is my WebService Function which returns response in string
            return response;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            System.out.println("result is: "+result);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            }).start();

        // SHOW THE ALERT DIALOG HERE.....  
        }
    }