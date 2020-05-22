PublicKey public_key = CryptographyHelper.ellipticCurveCrypto().getPublic();     
System.out.println("PUBLIC KEY::" + public_key);

//converting public key to byte            
byte[] byte_pubkey = public_key.getEncoded();
System.out.println("\nBYTE KEY::: " + byte_pubkey);

//converting byte to String 
String str_key = Base64.getEncoder().encodeToString(byte_pubkey);
// String str_key = new String(byte_pubkey,Charset.);
System.out.println("\nSTRING KEY::" + str_key);

//converting string to Bytes
byte_pubkey  = Base64.getDecoder().decode(str_key);
System.out.println("BYTE KEY::" + byte_pubkey);


//converting it back to public key
KeyFactory factory = KeyFactory.getInstance("ECDSA", "BC");
public_key = (ECPublicKey) factory.generatePublic(new X509EncodedKeySpec(byte_pubkey));
System.out.println("FINAL OUTPUT" + public_key);