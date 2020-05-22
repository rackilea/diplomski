// Fields
public String val1;
public String val2;
public String val3;
  ... any value necessary

// Constructor
public WeatherData(JSONObject object) {
    try {
         val1 = object.optString("val1");
         val2 = object.optString("val2");
         val3 = object.optString("val3");
        ... parse here EVERYTHING from the object
    } catch (JSONException e) {
        e.printStackTrace();
    }
}