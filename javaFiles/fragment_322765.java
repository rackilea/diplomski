//strange static method from apache o.O
org.apache.xml.security.Init.init();
List<WSEncryptionPart> wsEncryptionParts = new ArrayList<>();
WSEncryptionPart somethingPart = new WSEncryptionPart("something","somethingNamespace","");
wsEncryptionParts.add(somethingPart);
sign.addReferencesToSign(wsEncryptionParts);