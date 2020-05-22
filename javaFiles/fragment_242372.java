HttpClient client = new DefaultHttpClient();
client.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, false);
HttpGet request = new HttpGet("<URL>");
HttpResponse response = client.execute(request);

//get all headers       
Header[] headers = response.getAllHeaders();
for (Header header : headers) {
    System.out.println("Key : " + header.getName() + " ,Value : " + header.getValue());
}