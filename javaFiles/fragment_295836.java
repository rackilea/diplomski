package nl.owlstead.stackoverflow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
    private Scanner inputFile;
    private PrintWriter outputFile;

    private static final String ALGO = "AES/CBC/PKCS5Padding";
    private byte[] keyValue;

    public Crypto(String key) {
        keyValue = key.getBytes();
    }

    public String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key,
                new IvParameterSpec(new byte[c.getBlockSize()]));
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }

    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key,
                new IvParameterSpec(new byte[c.getBlockSize()]));
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, "AES");
        return key;
    }

    public void encrypt_decrypt(String function_type, String source_file,
            String target_file) {
        String lineValue = "";
        String convertedValue = "";
        try {
            inputFile = new Scanner(new File(source_file));
        } catch (Exception e) {
            System.out.println("( " + source_file + ") - File Opening Error");
        }
        try {
            outputFile = new PrintWriter(new FileWriter(target_file));
        } catch (Exception e) {
            System.out.println("( " + target_file + ") - File Opening Error");
        }

        while (inputFile.hasNext()) {
            lineValue = inputFile.nextLine();
            System.out.println("Source Line: " + lineValue);

            try {
                if (function_type == "ENCRYPT") {
                    convertedValue = encrypt(lineValue);
                } else if (function_type == "DECRYPT") {
                    convertedValue = decrypt(lineValue);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Converted Line : " + convertedValue);

            outputFile.println(convertedValue);
        }

        inputFile.close();
        outputFile.close();
    }

    public static void main(String args[]) throws IOException {

        Crypto c = new Crypto("dk201anckse29sns");
        c.encrypt_decrypt("ENCRYPT", "CryptoPlaintext.txt",
                "CryptoCiphertext.txt");
        c.encrypt_decrypt("DECRYPT", "CryptoCiphertext.txt",
                "CryptoDeciphered.txt");

        System.out.println(compareFiles() ? "The files are identical!"
                : "The files are NOT identical.");
    }

    /**
     * Compares the Plaintext file with the Deciphered file.
     *
     * @return true if files match, false if they do not
     */

    public static boolean compareFiles() throws IOException {

        Scanner pt = new Scanner(new File("CryptoPlaintext.txt")); // Open the
        Scanner dc = new Scanner(new File("CryptoDeciphered.txt")); // Open the

        // Read through the files and compare them record by record.
        // If any of the records do not match, the files are not identical.

        while (pt.hasNextLine() && dc.hasNextLine()) {
            String ptl = pt.nextLine();
            String dcl = dc.nextLine();
            if (!ptl.equals(dcl))
            {
                System.out.println(ptl);
                System.out.println(dcl);
                continue;
//              return false;

        }
            }
        // If we have any records left over, then the files are not identical.

        if (pt.hasNextLine() || dc.hasNextLine())
            return false;

        // The files are identical.

        return true;
    }
}