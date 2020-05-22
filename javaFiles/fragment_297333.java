String headerLine = "NAME;AGE;HEIGHT";
String[] headers = headerLine.split(";");
Map<String,Integer> map = new HashMap<String,Integer>();
for (int i=0; i<headers.length; i++) {
  map.put(headers[i], i);
}