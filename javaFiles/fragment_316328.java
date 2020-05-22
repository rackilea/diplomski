PemObject pemObject = new PemObject("CERTIFICATE REQUEST", certRequest.getEncoded());
StringWriter str = new StringWriter();
PEMWriter pemWriter = new PEMWriter(str);
pemWriter.writeObject(pemObject);
pemWriter.close();
str.close();
System.out.println(str);