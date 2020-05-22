Response response = new ResteasyClientBuilder()
        .build()
        .target(UriBuilder.fromPath("https://foo.bar"))
        .queryParam("url", "{urlTemplate}")
        .resolveTemplate("urlTemplate", "http://hostname.com/The%20URL%20with spaces.jpg")
        .request()
        .get();