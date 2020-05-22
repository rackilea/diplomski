public static String stringToHex(String arg) {
    return String.format("%x", new BigInteger(1, arg.getBytes(Charset.forName("UTF-8"))));
}

public static String hexToString(String arg) {
    byte[] bytes = DatatypeConverter.parseHexBinary(arg);
    return new String(bytes, Charset.forName("UTF-8"));
}