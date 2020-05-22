FileInputStream fis = new FileInputStream("<path_to_pfx_file>");
java.security.KeyStore ks = java.security.KeyStore.getInstance("PKCS12");
ks.load(fis,"pfx_password".toCharArray());
Certificate cert = ks.getCertificate("certificate_alias");

BASE64Encoder encoder = new BASE64Encoder();        
FileOutputStream fos = new FileOutputStream("<path_to_generated_pem_file>");
fos.write(X509Factory.BEGIN_CERT.getBytes());
encoder.encodeBuffer(cert.getEncoded(), fos);
fos.write(X509Factory.END_CERT.getBytes());

fos.flush();
fos.close();