String auth =req.headers("Authorization");
if ( auth != null && auth.startsWith("Negotiate ")) {
    //smells like an SPNEGO request, so get the token from the http headers
    String authBody = auth.substring("Negotiate ".length());
    if (authBody.startsWith("oY")) {
        // This is a NegTokenTarg from IE, which GSS API does not properly handle.
        // However if we chop of the first (28) chars, we find a Kerberos Token starting with "60 82 0C" that GSS can handle.            
        authBody=authBody.substring(authBody.indexOf("YI", 2));
     }

     try {                 
         byte gssapiData[] = Base64.getDecoder().decode(authBody);               
         gssContext = initGSSContext(MyUtils.SPNEGOOID, MyUtils.KRB5OID);
         byte token[] = gssContext.acceptSecContext(gssapiData, offset, gssapiData.length);


         ..etc.