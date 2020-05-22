import java.security.*;

KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
KeyPair keyPair = keyPairGenerator.generateKeyPair();
PublicKey publicKey = keyPair.getPublic();
PrivateKey privateKey = keyPair.getPrivate();