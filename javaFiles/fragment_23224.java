key1 = (AESKey) KeyBuilder.buildKey(KeyBuilder.TYPE_AES,
     KeyBuilder.LENGTH_AES_128, false);
key2 = (AESKey) KeyBuilder.buildKey(KeyBuilder.TYPE_AES,
     KeyBuilder.LENGTH_AES_128, false);
...
cipher.init(key1, Cipher.MODE_DECRYPT);
cipher.init(key2, Cipher.MODE_ENCRYPT);