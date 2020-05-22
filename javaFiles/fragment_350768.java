@Override
protected void onPostExecute(JSONObject o) {
    super.onPostExecute(o);
    Log.d("Json:", o.toString());
    UpdateDisplay(WeatherParser.ParseFeed(o));
}