private static String decryptStringWithXORFromHex(String input,String key) {
    StringBuilder c = new StringBuilder();
    while (key.length() < input.length()/2) {
        key += key;
    }

    for (int i=0;i<input.length();i+=2) {
        String hexValueString = input.substring(i, i+2);
        int value1 = Integer.parseInt(hexValueString, 16);
        int value2 = key.charAt(i/2);

        int xorValue = value1 ^ value2;

        c.append(Character.toString((char) xorValue));

    }
    return c.toString();
};