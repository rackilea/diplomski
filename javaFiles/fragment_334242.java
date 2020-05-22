import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is a utility class allows to encrypt/ decrypt the data received by a Scanner {@see Scanner} using the caesar
 * encoding by providing the key to be used.
 *
 * Note: Behind the scanner there may be a File or System.in as source
 */
public class CaesarUtility {

    /**
     * TODO: implement a mechanism to encrypt data ({@see Scanner}) and write the encrypted data out ({@see PrintWriter})
     * TODO: use the provided key for encryption
     * @param in source for the data to be encrypted {@see Scanner}
     * @param out destination for the encrypted data to be written to {@see PrintWriter}
     * @param key key to be used for the encryption
     */
    public static void encrypt (Scanner in, PrintWriter out, String key){

        // TODO: do we need to validate something? Could something be null? Do we need to care about this?

        // TODO: Read from Scanner
        String dataToEncrypt = "TODO: Read from Scanner";

        // TODO: Encryption
        String encryptedData = "Use your existing Caesar Driver with the correct method to encrypt the data";

        // TODO: Write encrpyted data using the provided PrintWriter
    }

    /**
     * TODO: The same like in encrypt but decrypt data this time
     * @param in source for the data to be decrypted {@see Scanner}
     * @param out destination for the decrypted data to be written to {@see PrintWriter}
     * @param key key to be used for the decryption
     */
    public static void decrypt (Scanner in, PrintWriter out, String key){

        // TODO: Basicially the same but for decryption (e.g. you will use your driver slightly different here :))

    }
}