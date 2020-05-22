public void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);
setContentView(R.layout.map);
TextView lattv=(TextView)findViewById(R.id.lat);
TextView lngtv=(TextView)findViewById(R.id.lng);
JSONParstring jParser = new JSONParstring();
String json = jParser.getJSONFromUrl(url);
// getting JSON string from URL
String lat ="",lng="";
try
{
    JSONObject jobj = new JSONObject(json);

    res = jobj.getJSONArray(TAG_RESULTS);
    for(int i = 0; i < res.length(); i++){
        JSONObject c = res.getJSONObject(i);

        JSONObject loc = c.optJSONObject(TAG_GEO).optJSONObject(TAG_LOCATION);

    lat =loc.getString(TAG_LAT);

    lng = loc.getString(TAG_LNG);

    //lattv.setText(lat);
    //lngtv.setText(lng);
    Log.i("Lat",lat);

    }
}
catch (JSONException e){ }
//String i=(String) lattv.getText();
//String j=(String) lngtv.getText();

double lat1 = Double.parseDouble(lat);  
double lng1 = Double.parseDouble(lng);