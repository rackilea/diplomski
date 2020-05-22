RijndaelEngine rijndaelEngine = new RijndaelEngine(256); // *1 *2
KeyParameter keyParam = new KeyParameter(rijndaelKeyBytes)
rijndaelEngine.init(false, keyParam);  //false == decrypt
PaddedBufferedBlockCipher bbc = new PaddedBufferedBlockCipher(rijndaelEngine, new ZeroBytePadding()); // *3 

byte[] decryptedBytes = new byte[decryptedLenght]; //from the storageOptions string
int processed = bbc.processBytes(inputBytes, 0, inputBytes.length, decryptedBytes, 0);
bbc.doFinal(decryptedBytes, processed);