String code;
do {
    code = Integer.toString((int) (Math.random() * Integer.MAX_VALUE), 36);
    if (code.length() > 6)
       code = code.substring(0, 6);
} while(!code.matches(".*\\w.*") || !code.matches(".*\\d.*") || code.length() < 6);