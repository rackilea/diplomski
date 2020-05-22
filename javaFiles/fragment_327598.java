KeyStore one = KeyStore.getInstance(your_ks_type); // optionally add ,provider
try(InputStream is = new FileInputStream(filename)){ one.load(is,pw); }
// or other input source like JAR, server, whatever
PrivateKey privkey = (PrivateKey) one.getKey (alias,pw);
// keypass is _usually_ same as storepass but may differ for some keystores like JKS 
Certificate[] chain one.getCertificateChain (alias);
// use java.security.cert.Certificate, not the obsolete java.security.Certificate 

KeyStore two = KeyStore.getInstance("JKS"); // any filebased type (and optionally provider)
// doesn't matter which since we don't read or write it
two.load(null); // dummy call makes it ready to use
two.setKeyEntry (dummyalias, privkey, pwx, chain);
// two now contains (in memory only) the single privateKey entry