HttpPost httpPost = new HttpPost("http://host:port/test/login");

String encoding = Base64Encoder.encode ("your_user:your_password");
httpPost.setHeader("Authorization", "Basic " + encoding);

String proxyEncoding = Base64Encoder.encode ("proxy_user:proxy_password");
httpPost.setHeader("Proxy-Authorization", "Basic " + proxyEncoding);

System.out.println("executing request " + httpPost.getRequestLine());
HttpResponse response = httpClient.execute(httpPost);