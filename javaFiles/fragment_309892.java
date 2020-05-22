// once at he beginning of your program (before any use of default SSLContext)
// or instead can be done on the command line with -Dprop=value 
System.setProperty ("javax.net.ssl.keyStore", filepath);
System.setProperty ("javax.net.ssl.keyStorePassword", password);
System.setProperty ("javax.net.ssl.keyStoreType", "PKCS12" or "JKS"); -- if not default
System.setProperty ("javax.net.ssl.trustStore", filepath);
System.setProperty ("javax.net.ssl.trustStorePassword", password);
System.setProperty ("javax.net.ssl.trustStoreType", "PKCS12" or "JKS"); -- if not default

// when (each time) you want to make a request:
URL url = new URL ("https://hello-signs.api-dev.myname.com/v2/oauth2/client_credential/accesstoken?grant_type=client_credentials");
HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
// we aren't actually using S-specific items, so could instead use 
// HttpURLConnection especially if you want to mix HTTPS and HTTP;
// or you could use the Https version to tweak some SSL/TLS parameters
conn.setRequestMethod ("POST");
conn.setRequestHeader ("Content-Type","application/x-www-form-urlencoded");
conn.setDoOutput (true);
OutputStream os = conn.getOutputStream(); 
os.write ("client_id=xxccvvbbnniioopp&client_secret=zoopopopopopppp".getBytes());
os.close();
os.connect(); // optional, can help localize exceptions

// depending on what you want to do with the result(s):
... conn.getResponseCode() and/or conn.getResponseMessage() ...
... conn.getHeaderField{,Int,Long,s}("id") ...
... conn.getContent{Type,Length[Long],Encoding,}() ... 
... conn.getInputStream() then read from it, including decoding various formats or charsets as needed/desired ...
conn.disconnect(); // when done