String url = baseUrl + "?";
for (String key : parameterMap.keys())
{
  String value = parameterMap.get(key);
  String encoded = URLEncoder.encode(value, "UTF-8");
  url += key + "&" + encoded;
}