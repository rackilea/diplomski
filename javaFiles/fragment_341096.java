URI url = new URI("http://www.chicagotribune.com/news/ct-college-of-dupage-investigation-met-20150330-story.html");
        Netty4ClientHttpRequestFactory asyncRequestFactory = new Netty4ClientHttpRequestFactory();
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(asyncRequestFactory);
        ListenableFuture<ResponseEntity<String>> entity = asyncRestTemplate.getForEntity(url, String.class);
        System.out.println("entity.get() = " + entity.get());
        asyncRequestFactory.destroy();