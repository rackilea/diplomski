SSLClient client = new SSLClient();
char[] pwd = "secret".toCharArray();

client.addTrustMaterial( TrustMaterial.DEFAULT );
client.addTrustMaterial( new TrustMaterial( "/path/to/self-signed.pem" ) );
client.addTrustMaterial( new KeyMaterial( "/path/to/keystore.jks", pwd ) );

client.setCheckHostname( true ); // default is "true" 
client.setCheckExpiry( true );   // default is "true" 
client.setCheckCRL( true );      // default is "true" 

// load a client certificate (max: 1 per SSLClient instance).
client.setKeyMaterial( new KeyMaterial( "/path/to/client.pfx", "secret".toCharArray() ) );
SSLSocket s = (SSLSocket) client.createSocket( "www.mysite.com", 443 );