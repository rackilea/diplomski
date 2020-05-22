KeyStore keyStore = keyStore.getInstance(KeyStore.getDefaultType());
keyStore.load( inputStream, storePassword.getBytes() );

// Get a key
if ( keyStore.isKeyEntry(alias) ) {
   Key key = keyStore.getKey(alias, keyPassword.getBytes());
}

// Store a new key
KeyFactory keyFactory = KeyFactory.getInstance(KeyStore.getDefaultType());
KeySpec keySpec ...; // depends on what kind of key you want to create (ie. rsa, etc..)
Key key = keyFactory.generatePrivate(keySpec);
// sign the key here
Certificate certChain[] = ...; // get the cert chain
keyStore.setKeyEntry(newAlias, newKey, newKeyPassword.getBytes(), certChain);
keyStore.store(outputStream, storePassword.getBytes());