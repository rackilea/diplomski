// Create an instance of HttpClient.
  HttpClient client = new HttpClient();

  // Create a method instance.
  GetMethod method = new GetMethod("http://localhost:9000/giveMeString");

  // Execute the method.
  int statusCode = client.executeMethod(method);

  // Read the response body.
  byte[] responseBody = method.getResponseBody();

  //Print the response
  System.out.println(new String(responseBody));