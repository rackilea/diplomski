FileInputStream fileInputStream = new FileInputStream( "keystore" + File.separator + "ClientRegistrarKeyStore.jks" );
keyStore.load( fileInputStream, "keystore".toCharArray() );
fileInputStream.close();
keyStore.setCertificateEntry( alias, new X509Certificate( trustedCertificate ) );

FileOutputStream fileOutputStream = new FileOutputStream( "keystore" + File.separator + "ClientRegistrarKeyStore.jks" );
keyStore.store( fileOutputStream, "keystore".toCharArray() );
fileOutputStream.close();