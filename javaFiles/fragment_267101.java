ByteArrayInputStream bais = new ByteArrayInputStream(responseBytes);
GZIPInputStream gzis = new GZIPInputStream(bais);
InputStreamReader reader = new InputStreamReader(gzis);
BufferedReader in = new BufferedReader(reader);

String readed;
while ((readed = in.readLine()) != null) {
    System.out.println(readed);
}