import java.util.Properties;
...
Properties systemProps = System.getProperties();
systemProps.put("javax.net.ssl.keyStorePassword","passwordForKeystore");
systemProps.put("javax.net.ssl.keyStore","pathToKeystore.ks");
systemProps.put("javax.net.ssl.trustStore", "pathToTruststore.ts");
systemProps.put("javax.net.ssl.trustStorePassword","passwordForTrustStore");
System.setProperties(systemProps);
...