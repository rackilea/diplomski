public class Client {
       private static void configureSSLOnTheClient(Object c) {
          org.apache.cxf.endpoint.Client client = ClientProxy.getClient(c);
          HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

          try {
              TLSClientParameters tlsParams = new TLSClientParameters();
              tlsParams.setDisableCNCheck(true);

              KeyStore keyStore = KeyStore.getInstance("JKS");
              String trustpass = "password";

              File truststore = new File("certs\\truststore.jks");
              keyStore.load(new FileInputStream(truststore), trustpass.toCharArray());
              TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
              trustFactory.init(keyStore);
              TrustManager[] tm = trustFactory.getTrustManagers();
              tlsParams.setTrustManagers(tm);

              truststore = new File("certs\\wibble.jks");
              keyStore.load(new FileInputStream(truststore), trustpass.toCharArray());
              KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
              keyFactory.init(keyStore, trustpass.toCharArray());
              KeyManager[] km = keyFactory.getKeyManagers();
              tlsParams.setKeyManagers(km);

              FiltersType filter = new FiltersType();
              filter.getInclude().add(".*_EXPORT_.*");
              filter.getInclude().add(".*_EXPORT1024_.*");
              filter.getInclude().add(".*_WITH_DES_.*");
              filter.getInclude().add(".*_WITH_NULL_.*");
              filter.getExclude().add(".*_DH_anon_.*");
              tlsParams.setCipherSuitesFilter(filter);

              httpConduit.setTlsClientParameters(tlsParams);
          } catch (KeyStoreException kse) {
              System.out.println("Security configuration failed with the following: " + kse.getCause());
          } catch (NoSuchAlgorithmException nsa) {
              System.out.println("Security configuration failed with the following: " + nsa.getCause());
          } catch (FileNotFoundException fnfe) {
              System.out.println("Security configuration failed with the following: " + fnfe.getCause());
          } catch (UnrecoverableKeyException uke) {
              System.out.println("Security configuration failed with the following: " + uke.getCause());
          } catch (CertificateException ce) {
              System.out.println("Security configuration failed with the following: " + ce.getCause());
          } catch (GeneralSecurityException gse) {
              System.out.println("Security configuration failed with the following: " + gse.getCause());
          } catch (IOException ioe) {
              System.out.println("Security configuration failed with the following: " + ioe.getCause());
          }
      }

      public static void main(String args[]) {
          System.out.println("The client's security configuration will be done programatically.");
          System.out.println();
          String address = "https://localhost:9001/SoapContext/SoapPort";
          JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
          proxyFactory.setServiceClass(Greeter.class);
          proxyFactory.setAddress(address);

          Greeter client = (Greeter) proxyFactory.create();
          configureSSLOnTheClient(client);

          System.out.println("Invoking greetMe...");
          try {
              String resp = client.greetMe(System.getProperty("user.name"));
              System.out.println("Server responded with: " + resp);
              System.out.println();

          } catch (Exception e) {
              System.out.println("Invocation failed with the following: " + e.getCause());
              System.out.println();
          }

      }
  }