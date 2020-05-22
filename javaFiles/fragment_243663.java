URL uri = new URL(url);
HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
connection.setRequestProperty("Accept-Encoding","gzip");
Map<String, List<String>> map = connection.getHeaderFields();
for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    System.out.println("Key : " + entry.getKey() +
        " ,Value : " + entry.getValue());
}