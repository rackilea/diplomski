public static byte[] encrypt3DESECB(byte[] keyBytes, byte[] dataBytes) {
    try {
        if (keyBytes.length == 16) { // short key ? .. extend to 24 byte key 
            byte[] tmpKey = new byte[24];
            System.arraycopy(keyBytes, 0, tmpKey, 0, 16);
            System.arraycopy(keyBytes, 0, tmpKey, 16, 8);
            keyBytes = tmpKey;
        }

        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "DESede");
        ...
        ...