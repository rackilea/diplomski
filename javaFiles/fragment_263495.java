private static int parity(String binaryStr) {
    if (binaryStr.length() == 0) {
        return 0;
    } else {
        return ((binaryStr.charAt(0) == '0') ? 0 : 1) ^ parity(binaryStr.substring(1));
    }
}