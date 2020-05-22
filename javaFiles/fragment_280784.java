public static String jumpEncrypt(String message, int jumpValue) {
    String jencrypt = "";

    for (int i = 0; i < jumpValue; i++) {
        for (int j = 0; j < (message.length() + jumpValue - 1) / jumpValue; j++) {
            int index = i + j * jumpValue;
            if (index < message.length()) {
                jencrypt += message.charAt(index);
            }
        }
    }

    return jencrypt;
}