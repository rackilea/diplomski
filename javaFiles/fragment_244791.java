JSONArray arr = new JSONArray();
for (... metric in some other array ...) {
  JSONObject obj = GetMetrics.metricAsJSON(key, value);
  arr.put(obj);
}
String jsonString = arr.toString();
/* Write jsonString to file */