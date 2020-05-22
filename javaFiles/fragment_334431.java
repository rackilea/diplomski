import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;

// don't forget to add the provider
Security.addProvider(new BouncyCastleProvider());
String password = "your password";

// reads your key file
PEMParser pemParser = new PEMParser(new FileReader(keyFile));
Object object = pemParser.readObject();
JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

KeyPair kp;
if (object instanceof PEMEncryptedKeyPair) {
    // Encrypted key - we will use provided password
    PEMEncryptedKeyPair ckp = (PEMEncryptedKeyPair) object;
    // uses the password to decrypt the key
    PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
    kp = converter.getKeyPair(ckp.decryptKeyPair(decProv));
} else {
    // Unencrypted key - no password needed
    PEMKeyPair ukp = (PEMKeyPair) object;
    kp = converter.getKeyPair(ukp);
}

// RSA
KeyFactory keyFac = KeyFactory.getInstance("RSA");
RSAPrivateCrtKeySpec privateKey = keyFac.getKeySpec(kp.getPrivate(), RSAPrivateCrtKeySpec.class);

System.out.println(privateKey.getClass());