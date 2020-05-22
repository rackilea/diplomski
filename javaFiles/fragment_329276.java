@NonNull
static String encryptMessage(@NonNull String plainMessage,
                             @NonNull SharedPreferences storage,
                             @Nullable Key aesKey,
                             @NonNull String charset) {
        //...
        // add spaces (custom padding) until the plainMessage.getBytes can be divided by 16 without rest --> this is the solution I was looking for
        while (plainMessage.getBytes().length % 16 != 0) {
            plainMessage += '\u0020';
        }
        //...
}

@NonNull
static String decryptMessage(@NonNull String encryptedMessage,
                             @NonNull SharedPreferences storage,
                             @Nullable Key aesKey,
                             @NonNull String charset) {
        //...
        // trim the String to get rid of the spaces
        return new String(charsetEncryptedData, charset).trim();
        //...
}