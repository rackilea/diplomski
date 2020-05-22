@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
       //The intent from this method is the one you need to get data from!
       if (requestCode == 1) {
       // Make sure the request was successful
            if (resultCode == RESULT_OK) {
               audioPath = intent.getData().getPath(); 
               audio = Uri.parse(audioPath);
              }
        }
     }