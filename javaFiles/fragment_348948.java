import java.security.*;
import java.security.spec.*;

KeyFactory keyFactory = KeyFactory.getInstance("RSA");
byte[] publicKeyBytes = publicKey.getEncoded();
KeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);