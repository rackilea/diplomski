HttpClient client = new DefaultHttpClient();
  HttpGet request = new HttpGet('http://site/MyrestUrl');
  HttpResponse response = client.execute(request);
  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
  String line = '';
  while ((line = rd.readLine()) != null) {
    System.out.println(line);
  }
  return (rd);