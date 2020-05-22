package javatest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.security.PrivateKey;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

/**
 * Test decrypt file
 *
 * @author a.chernyy
 */
public class JavaTest {

    /**
     * String to hold name of the encryption algorithm.
     */
    public static final String ALGORITHM = "RSA";

    /**
     * String to hold the path to the keys' dir.
     */
    public static final String KEYS_DIR = "D:" + File.separator + "keystore" + File.separator;

    /**
     * String to hold the name of the private key file.
     */
    public static final String PRIVATE_KEY_FILE = KEYS_DIR + "priv.key";

    /**
     * String to hold name of the public key file.
     */
    public static final String CERT_FILE = KEYS_DIR + "cert.cer";

    /**
     * String to hold name of the encrypted file.
     */
    public static final String ENCRYPTED_FILE = "D:" + File.separator + "Temp" + File.separator + "encrypted.xml";

    /**
     * String to hold name of the decrypted file.
     */
    public static final String DECRYPTED_FILE = "D:" + File.separator + "Temp" + File.separator + "decrypted.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //get private key
            File keyFl = new File(PRIVATE_KEY_FILE);
            Security.addProvider(new BouncyCastleProvider());
            PEMParser pemParser = new PEMParser(new InputStreamReader(new FileInputStream(keyFl)));
            PEMKeyPair pemKeyPair = (PEMKeyPair) pemParser.readObject();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            PrivateKey privateKey = converter.getPrivateKey(pemKeyPair.getPrivateKeyInfo());
            
            //Decrypt file
            File encryptedFile = new File(ENCRYPTED_FILE);
            File decryptedFile = new File(DECRYPTED_FILE);
            Files.deleteIfExists(decryptedFile.toPath());
            Security.addProvider(new BouncyCastleProvider());
            EncryptAndDecrypt.decrypt(privateKey, encryptedFile, decryptedFile);
        } catch (Exception e) {
            System.out.println("It's a pity...");
            System.err.println(e.getMessage());
        }
        System.out.println("THE END");
    }

}