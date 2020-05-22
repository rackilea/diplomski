HttpResponse res = WS.url("http://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=true").get();

JsonElement json = res.getJson();
System.out.println("JSON: " + json);
//with a system out i can see that the json is parsed correctly
JsonArray jsArr = json.getAsJsonObject().getAsJsonArray("results");

for (JsonElement jsEl : jsArr)
{
  JsonObject locationObject = jsEl.getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");
  double lat = locationObject.getAsJsonPrimitive("lat").getAsDouble();
  double lng = locationObject.getAsJsonPrimitive("lng").getAsDouble();

  System.out.println("Lat is " + lat + " and lng is " + lng);
}