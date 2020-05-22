public static String sha256(String paramString) {
    try {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        byte[] binaryDigest = localMessageDigest.digest(paramString.getBytes());
        return DatatypeConverter.printHexBinary(binaryDigest);
    } catch (NoSuchAlgorithmException e) {
        // ThrowableExtension.printStackTrace(e);
    }
    return null;
}