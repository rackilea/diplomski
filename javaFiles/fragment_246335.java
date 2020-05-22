HttpClient.Factory httpClientFactory = new ApacheHttpClient.Factory();
HttpClient client = httpClientFactory.createClient(remoteServerAddress);

HttpRequest httpRequest = commandCodec.encode(command);
HttpResponse httpResponse = client.execute(httpRequest, true);
Response response = responseCodec.decode(httpResponse);