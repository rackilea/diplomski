// Create a static instance of cookie store globally 

     cookieStore = new BasicCookieStore();

 // Create local HTTP context

    HttpContext localContext = new BasicHttpContext();

// Bind custom cookie store to the local context
localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//execute your connection with context
  HttpResponse response = http.execute(post,localContext);


And then whenever you connect use that static cookie instance to connect
HttpContext localContext = new BasicHttpContext();
// Bind custom cookie store to the local context
localContext.setAttribute(ClientContext.COOKIE_STORE, StaticInstance(cookieStore));
//and as usual
response = http.execute(post,localContext);