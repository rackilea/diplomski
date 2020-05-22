public static void main(String[] args) {
        String str = "\tSome text [à]";

        try {
            System.out.println(str); //     Some text [à]

            String windowsLatin1 = "Cp1252";
            String hexString = toHex(windowsLatin1, str);

            System.out.println(hexString); // 09536f6d652074657874205be05d

            String winString = toString(windowsLatin1, hexString);

            System.out.println(winString); //   Some text [à]
        } catch (UnsupportedEncodingException e) {
            // Should not happen.
        }

    }

    public static String toString(String encoding, String hexString) throws UnsupportedEncodingException {
        int length = hexString.length();
        byte [] buffer = new byte[length/2];
        for (int i = 0; i < length ; i+=2) {
            String hexVal = hexString.substring(i,i+2);
            byte code = (byte) Integer.parseInt(hexVal,16);
            buffer[i/2]=code;
        }
        String winString = new String(buffer,encoding);
        return winString;
    }

    public static String toHex(String encoding, String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(encoding);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            String hexChar = Integer.toHexString(b & 0xff);
            if(hexChar.length()<2) {
                builder.append('0');
            }
            builder.append(hexChar);
        }
        String hexString = builder.toString(); // 09536f6d652074657874205be05d
        return hexString;
    }