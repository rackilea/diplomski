class AsyncTaskRunner extends AsyncTask<Void, Void, String> {

  private Context ctx;
  public AsyncTaskRunner(Context ctx){
      this.ctx = ctx;
  }

  protected void onPostExecute(String result) {
         // super.onPostExecute(result);

      DatabaseHandler db = new DatabaseHandler(ctx);
         try{
                JSONArray arr = new JSONArray(result);
                db.dropAll();
                for (int i=0; i<arr.length(); i++){
                JSONObject jObj = arr.getJSONObject(i);
                db.addEvent(new Event(jObj.getString("course"), jObj.getString("date"), jObj.getString("time"), jObj.getString("event")));        
                }
            }
            catch (JSONException e) {e.printStackTrace();}

     }