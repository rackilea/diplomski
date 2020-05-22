ByteArrayInputStream inputStream = new ByteArrayInputStream(live_data);
GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
BufferedReader bf = new BufferedReader(new 
InputStreamReader(gzipInputStream, "UTF-8"));
String outStr = "";
String line;
while ((line=bf.readLine())!=null) {
     outStr += line;
}