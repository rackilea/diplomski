public class LargeTask extends AsyncTask<String, Void, Void> {
     protected void doInBackground(String... strings) {
         String your_string = strings[0]; //Retrieve the first parameter
         //Your "big reading function" goes here
     }

     protected void onPostExecute(Void result) {
         //Do something when done
     }
 }