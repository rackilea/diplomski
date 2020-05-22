CloseableHttpClient client = HttpClients.createDefault();

HttpPost post = new HttpPost("https://accounts.spotify.com/api/token");
post.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
post.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoded);
StringEntity data = new StringEntity("grant_type=client_credentials");
post.setEntity(data);

HttpResponse response = client.execute(post);