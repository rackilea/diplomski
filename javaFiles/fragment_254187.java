URIBuilder builder = new URIBuilder();
builder.setScheme("http").setHost("www.google.com").setPath("/search")
    .setParameter("q", "httpclient")
    .setParameter("btnG", "Google Search")
    .setParameter("aq", "f")
    .setParameter("oq", "");
URI uri = builder.build();
HttpGet httpget = new HttpGet(uri);
System.out.println(httpget.getURI());