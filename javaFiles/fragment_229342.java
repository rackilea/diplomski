public byte[] encrypt(byte[] plain) throws Exception {
    byte[] iv = ecipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
    byte[] ct = ecipher.doFinal(plain);
    byte[] result = new byte[ct.length + iv.length];
    System.arraycopy(iv, 0, result, 0, iv.length);
    System.arraycopy(ct, 0, result, iv.length, ct.length);
    return result;
}

public byte[] decrypt(byte[] encrypt) throws Exception {
    byte[] iv = new byte[dcipher.getBlockSize()];
    byte[] ct = new byte[encrypt.length - dcipher.getBlockSize()];
    System.arraycopy(encrypt, 0, iv, 0, dcipher.getBlockSize());
    System.arraycopy(encrypt, dcipher.getBlockSize(), ct, 0, ct.length);

    dcipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
    return dcipher.doFinal(ct);
}