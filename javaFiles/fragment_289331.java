DefaultHttpClient client = new DefaultHttpClient();
HttpHost targetHost = new HttpHost("google.com", 80, "http"); 
HttpGet httpget = new HttpGet("about-us.html");
BasicHttpContext localContext = new BasicHttpContext();
HttpResponse response = null;

try { response = client.execute(targetHost, httpget, localContext); 
      System.out.println(response.getStatusLine()
}
catch(Exception e){
    // Enter error-handling code here.
}