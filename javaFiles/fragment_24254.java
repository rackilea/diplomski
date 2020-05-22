KeyPair keyPair = ...;//You already have this  
X509Certificate certificate = generateCertificate(keyPair);  
KeyStore keyStore = KeyStore.getInstance("JKS");  
keyStore.load(null,null);  
Certificate[] certChain = new Certificate[1];  
certChain[0] = certificate;  
keyStore.setKeyEntry("key1", (Key)keyPair.getPrivate(), pwd, certChain);