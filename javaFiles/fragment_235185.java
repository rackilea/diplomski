public class MyAsyncTask extends AsyncTask<String, Integer, List<WeatherObject>>{

      @Override protected List<WeatherObject> doInBackground(String... params) {
         // here you call the API and parse the results
         // return ArrayList<WeatherObject> if successful, or `null` if failed
         return null;
      }

      @Override protected void onPostExecute(List<WeatherObject> weatherObjectList) {
           // here you simply check for null and use the List
           if(weatherObjectList == null){
               // fail to load data
           } else {
               // set data to adapter
           }
      }
   }