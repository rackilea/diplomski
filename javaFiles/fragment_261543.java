str = str.replaceAll("[()']", "");
String[] elements = str.split("&");
for (String elem : elements) {
  String[] pair = elem.split("=");
  String key = pair[0];
  String value = pair[1];
}