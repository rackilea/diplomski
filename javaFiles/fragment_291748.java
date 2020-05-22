public static String toRIPEMD160(String in) {
    try {
        byte[] addr = in.getBytes();
        byte[] out = new byte[20];
        RIPEMD160Digest digest = new RIPEMD160Digest();

        // These are the lines that changed
        byte[] rawSha256 = sha256(addr);
        String encodedSha256 = getHexString(rawSha256);
        byte[] strBytes = encodedSha256.getBytes("UTF-8");
        digest.update(strBytes, 0, strBytes.length);

        digest.doFinal(out, 0);
        return getHexString(out);
    } catch (UnsupportedEncodingException ex) {
        // Never happens, everything supports UTF-8
        return null;
    }
}