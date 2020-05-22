@Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1) {
     if (resultCode == RESULT_OK) {
     AsyncTask.execute(new Runnable() { 
     @Override public void run() { 
            //Write your code here which you want to execute after capture 
     }});} } }