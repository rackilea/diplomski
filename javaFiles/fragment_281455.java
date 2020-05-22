new DoMyCalculations(1000);    

private class DoMyCalculations extends AsyncTask<Integer, Integer, Integer> {
     protected Long doInBackground(Integer... params) {
         int sum = 0;
         for (int i = 0; i < params; i++) {
             sum += i;
             publishProgress(i);
         }
         return sum;
     }

     protected void onProgressUpdate(Integer... progress) {
         setProgressPercent(progress); //a function in your GUI which shows progress
     }

     protected void onPostExecute(Long result) {
         showDialog("Sum is: " + result);//a function in your GUI which shows results
     }
 }