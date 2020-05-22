URL url = new URL("<URL>");
URLConnection conn = url.openConnection();

//get all headers
Map<String, List<String>> map = conn.getHeaderFields();
for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
}