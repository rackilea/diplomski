JSONObject json = new JSONObject(jsonString);
JSONObject hitsObj = json.getJSONObject("hits");
JSONArray hitsArr = hitsObj.getJSONArray("hits");
JSONObject first = hitsArr.getJSONObject(0); // assumes 1 entry in hits array
JSONObject source = first.getJSONObject("_source");
JSONObject phone = source.getJSONObject("phone");

String id = source.getString("id");
String name = source.getString("name");
String mobile = phone.getString("mobile");
String home = phone.getString("home");

System.out.println(id + "\n" + name + "\n" + mobile + "\n" +home);