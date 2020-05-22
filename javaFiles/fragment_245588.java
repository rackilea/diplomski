@Override
       protected void onPostExecute(String result) {
           // Get the data from the RSS stream as a string

           errorText = (TextView)findViewById(R.id.error);
           response = (TextView)findViewById(R.id.title);

            response.setText(result);

            if(dialog.getProgress() == dialog.getMax())
            dialog.dismiss();

       }