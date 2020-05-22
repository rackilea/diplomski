public static int binaryToDecimalAssumingOnesComp(String binary) {
    if (binary.charAt(0) == '0') {
        return Integer.parseInt(binary, 2);
    } else {
        StringBuilder noMSB = new StringBuilder(binary.substring(1));
        for (int i = 0; i < noMSB.length(); i++) {
            if (noMSB.charAt(i) == '1') {
                noMSB.setCharAt(i, '0');
            }
            else if (noMSB.charAt(i) == '0') {
                noMSB.setCharAt(i, '1');
            }
        }
        return Integer.parseInt(noMSB.toString(), 2);
    }
}