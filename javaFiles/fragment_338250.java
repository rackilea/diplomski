byte[] btHash = new byte[] { ....the same.... };
KeyStore keystore = KeyStore.getInstance("PKCS12");
keystore.load(new FileInputStream("dummy.p12"), "1234".toCharArray());
PrivateKey privKey = (PrivateKey)keystore.getKey("Dummy", "1234".toCharArray());
byte[] asn=ArrayUtils.addAll(new byte[] { (byte)0x30, (byte)0x31, (byte)0x30, (byte)0x0d, (byte)0x06, (byte)0x09, (byte)0x60, (byte)0x86, (byte)0x48, (byte)0x01, (byte)0x65, (byte)0x03, (byte)0x04, (byte)0x02, (byte)0x01, (byte)0x05, (byte)0x00, (byte)0x04, (byte)0x20}, btHash);
Signature signature = Signature.getInstance("NONEwithRSA");
signature.initSign(privKey);
signature.update(asn);
byte[] ret = signature.sign();