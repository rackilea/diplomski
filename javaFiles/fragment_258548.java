Object node = jsonObject.get("mid_merchant");

String[] mid;
if (node instanceof JSONArray) {
   mid = new String[((JSONArray) node).size()];
} else {
   mid = new String[1];
}