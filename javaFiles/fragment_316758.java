public class SecurityUtil {

private static String passEncrypt;

/*
 * Get the message encrypted
 * @param String string to encrypt
 * @return encrypted message
 */
public static String Encryptor(String message){
    SecurityUtil.testEncryptPassSet();
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword(SecurityUtil.passEncrypt);        
    String encryptedText = encryptor.encrypt(message);
    return encryptedText;
}
/*
 * Get the decrypt message
 * @param encrypted message
 * @return String decrypted message
 * 
 */
public static String Decryptor(String message) {
    SecurityUtil.testEncryptPassSet();
    StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
    decryptor.setPassword(SecurityUtil.passEncrypt);  
    String decryptedText = decryptor.decrypt(message);
    return decryptedText;
}


/*
 * set the encryption password
*/
public static void setPassEncrypt(String passEncrypt) {
    SecurityUtil.passEncrypt = passEncrypt;
}

public static void testEncryptPassSet() {
    if (SecurityUtil.passEncrypt == null){
        System.out.println("Must set the password after");
    }
}

public static void main (String[] args){
    SecurityUtil.setPassEncrypt("Test"); //here you key
    String encrypted;
    System.out.println("Encrypted: "+(encrypted = SecurityUtil.Encryptor("This is a test message")));

    System.out.println("Decryp: "+SecurityUtil.Decryptor(encrypted));
}

}