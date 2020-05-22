//Convert to PKCS#1
  PrivateKeyInfo pkInfo = PrivateKeyInfo.getInstance(kg.getPrivateKey().getEncoded());
  ASN1Encodable encodable = pkInfo.parsePrivateKey();
  ASN1Primitive primitive = encodable.toASN1Primitive();
  byte[] privateKeyPKCS1 = primitive.getEncoded();
  //kg.writeToFile(PRIVATE_KEY_PATH, privateKeyPKCS1);

  //Convert to PEM
  PemObject pemObject = new PemObject("RSA PRIVATE KEY", privateKeyPKCS1);
  StringWriter stringWriter = new StringWriter();
  PemWriter pemWriter = new PemWriter(stringWriter);
  pemWriter.writeObject(pemObject);
  pemWriter.close();
  String pemString = stringWriter.toString();
  kg.writeToFile(PRIVATE_KEY_PATH, pemString.getBytes());