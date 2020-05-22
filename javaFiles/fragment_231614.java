public class AES256Cipher {

private static byte[] encrypt(byte[] ivBytes, byte[] keyBytes, byte[] textBytes)
        throws java.io.UnsupportedEncodingException,
        NoSuchAlgorithmException,
        NoSuchPaddingException,
        InvalidKeyException,
        InvalidAlgorithmParameterException,
        IllegalBlockSizeException,
        BadPaddingException {

    AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
    Cipher cipher = null;
    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
    return cipher.doFinal(textBytes);
}

private static byte[] decrypt(byte[] ivBytes, byte[] keyBytes, byte[] textBytes)
        throws java.io.UnsupportedEncodingException,
        NoSuchAlgorithmException,
        NoSuchPaddingException,
        InvalidKeyException,
        InvalidAlgorithmParameterException,
        IllegalBlockSizeException,
        BadPaddingException {

    AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
    return cipher.doFinal(textBytes);
}

final static String key = "0123456789abcdefghijklmnopqrstuv";

final static byte[] ivBytes = new byte[]{0x20, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

public static String encryptData(String plainText) {
    String base64Text = "";
    try {
        byte[] keyBytes = key.getBytes("UTF-8");
        byte[] x = plainText.getBytes("UTF-8");
        byte[] cipherData = encrypt(ivBytes, keyBytes, plainText.getBytes("UTF-8"));
        base64Text = Base64.encodeToString(cipherData, Base64.DEFAULT);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e) {
        e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
    } catch (BadPaddingException e) {
        e.printStackTrace();
    } catch (InvalidKeyException e) {
        e.printStackTrace();
    }
    return base64Text;
}

//############## Response(decrypt) ##############
public static String decryptData(String base64Text) {
    String plainText = "";
    try {
        byte[] keyBytes = key.getBytes("UTF-8");
        try {
            byte[] cipherData = decrypt(ivBytes, keyBytes, Base64.decode(base64Text.getBytes("UTF-8"), Base64.DEFAULT));
            plainText = new String(cipherData, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    return plainText;
}
}