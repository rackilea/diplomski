public void syncSQLiteMySQLDB() {
   // Create AsycHttpClient object
   AsyncHttpClient client = new AsyncHttpClient();
   // Http Request Params Object
   RequestParams params = new RequestParams();
   // Show ProgressBar
   prgDialog = new ProgressDialog(MainActivity.this);
   prgDialog.setMessage("Transferring Data from Remote MySQL DB and Syncing SQLite. Please wait...");
   prgDialog.setCancelable(false);
   prgDialog.show();

   // Make Http call to getusers.php
   client.post("http://download.grupsapte.ro/sinc/getusers.php", params, new AsyncHttpResponseHandler() {
           @Override
           public void onSuccess(String response) {

               // Update SQLite DB with response sent by getusers.php
               updateSQLite(response);
           }
           // When error occured
           @Override
           public void onFailure(int statusCode, Throwable error, String content) {
               // TODO Auto-generated method stub

               if (statusCode == 404) {
                   Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
               } else if (statusCode == 500) {
                   Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]",
                           Toast.LENGTH_LONG).show();
               }
           }

            @Override
            public void onFinish(){
                // Hide ProgressBar
                if(prgDialog.isShowing())
               prgDialog.hide();
            }
   });