byte[] keyBytes = Files.readAllBytes(Paths.get("./public_key.pub"));
String temp = new String(keyBytes);
String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----\n", "");
publicKeyPEM = publicKeyPEM.replace("\n-----END PUBLIC KEY-----", "");
BASE64Decoder b64= new BASE64Decoder();
byte[] decoded = b64.decodeBuffer(publicKeyPEM);
X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
KeyFactory kf = KeyFactory.getInstance("RSA");
publicKey = kf.generatePublic(spec);
Signature signature = Signature.getInstance("SHA256withRSA", "BC");
signature.initVerify(publicKey);
signature.update(bytesToVerify); //bytesToVerify = bytesToSign in go
byte[] signatureDecoded = Base64.getDecoder().decode(signatureString);
boolean endorserSignatureIsValid = signature.verify(signatureDecoded);
//It is now valid