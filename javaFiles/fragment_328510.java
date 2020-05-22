private class MyTask extends AsyncTask<Params, Progress, Result> {
     protected void onPreExecute() {
         // Before your task
     }

     protected Long doInBackground(Params... params) {
         // Your Task
         return result;
     }

     protected void onPostExecute(Result result) {
         // After your task
         startActivity(new Intent(LoadActivity.this, MainActivity.class));
         finish();
     }
}