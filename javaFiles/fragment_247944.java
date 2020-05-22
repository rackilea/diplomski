private class ProcessFrameTask extends AsyncTask {

 protected void doInBackground(Object... objs) {
     getFrame(); // Copy the frame
     calculateFrame(); // Do your magic
 }

 protected void onPostExecute(Long result) {
     showFrame(); // Post the result back to main thread
 }