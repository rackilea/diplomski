Log.d("defaultArrayShuffled", defaultArray.toString());

String temp = defaultArray.toString();
String temp1= temp.replaceAll("_white_", "_");
Log.d("temp1", temp1);

JSONObject temp2 = new JSONObject("{ \"arr\" : " + temp1 + "}");
//temp2.put("arr", temp1);
Log.d("temp2", temp2.toString());
replacingArray = temp2.getJSONArray("arr");