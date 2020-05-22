public String getWeather(Context cont,int cityid,String latitude, String longitude){
this.latitude=latitude;
this.longitude=longitude;

new get_scores() {
    protected void onPreExecute() {
        super.onPreExecute();

    }

    protected void onPostExecute(Boolean result) {

    }
}.execute();

  return new get_scores().execute();

}