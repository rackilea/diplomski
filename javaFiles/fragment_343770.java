// Start with your base method name, if necessary/known
String paramString = "methodName";
for (NameValuePair p : params ) {
    String n = p.getName();
    String v = p.getValue();
    if ( v == null ) {
        paramString += "&" + n;
    } else {
        paramString += "&" + n + "=" + v;
    }
}

String url = "http://example.com/Service/v1/service.ashx?" + URIUtil.encodeQuery(paramString);
HttpGet get = new HttpGet(url);