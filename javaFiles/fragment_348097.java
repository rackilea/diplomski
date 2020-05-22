protected void onProgressUpdate(Integer... progress) {
     setProgressPercent(progress[0]);
 }

 protected void onPostExecute(Long result) {
     showDialog("I pop up when all the code in the DoInbackground is finished");
 }