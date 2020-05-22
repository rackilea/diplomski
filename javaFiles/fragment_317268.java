String decodedUrl = "www.foo.com";
URIBuilder builder = new URIBuilder(decodedUrl);
builder.addParameter("sign", "AZrhQaTRSiys5GZtlwZ+H3qUyIY=");
builder.addParameter("more", "boo");
List<NameValuePair> params = builder.getQueryParams();
String sign = params.get(0).getValue();