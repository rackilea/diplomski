private static void saveKey(byte[] key, byte[] iv) throws IOException {
    File keyFile = new File("C:/cikey.key");
    keys.setProperty("key", toHexString(key));
    keys.setProperty("iv", toHexString(iv));
    keys.store(new FileOutputStream(keyFile.getAbsolutePath(), false), null);
}

private static byte[] readKey(String request) throws IOException {
    File keyFile = new File("C:/cikey.key");
    keys.load(new FileInputStream(keyFile));
    return toByteArray(keys.getProperty(request));
}

public static String toHexString(byte[] array) {
    return DatatypeConverter.printHexBinary(array);
}

public static byte[] toByteArray(String s) {
    return DatatypeConverter.parseHexBinary(s);
}