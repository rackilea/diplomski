BufferedReader in = new BufferedReader(new InputStreamReader(urlc.getInputStream()),8096);
String response;
while ((response = in.readLine()) != null) {
    System.out.println(response);
}
...