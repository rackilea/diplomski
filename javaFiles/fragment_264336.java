HttpClient client = new DefaultHttpClient();  
String url = "http://example.com/getmethod.aspx?id=111&method=Test";
HttpHead req = new HttpHead(url);
HttpResponse resp = client.execute(req);  
String lastMod = resp.getFirtHeader("Last-Modified")
if(lastMod != null) {
    //parse this string to get a date
    //it will be in this format: Wed, 15 Nov 1995 04:58:08 GMT
}