String url = "http://api.postcodes.io/postcodes";
HttpClient client = HttpClientBuilder.create().build();
HttpPost post = new HttpPost(url);

StringEntity params =new StringEntity("{\"postcodes\" : [\"OX49 5NU\", \"M32 0JG\", \"NE30 1DP\"]}");
post.addHeader("Content-Type", "application/json");
post.setEntity(params);