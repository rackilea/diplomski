private void callLoginApi(String username, String password)
{
  String authString = username + ":" + password;
  String authStringEnc = new 
  BASE64Encoder().encode(authString.getBytes());
  System.out.println("Base64 encoded auth string: " + authStringEnc);

  HttpClient client = HttpClientBuilder.create().build();
  HttpGet request = new HttpGet(FVConstants.loginAPI);
  request.addHeader("Authorization", "Basic " + authStringEnc);

  try {
      HttpResponse response = client.execute(request);
      System.out.println("response is : "+response.getStatusLine());

  } catch (Exception e) {
      e.printStackTrace();

  }
}