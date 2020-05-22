public static String hashPassword(String password) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    byte[] salt;
    byte[] buffer2;
    if (password == null)
        throw new IllegalArgumentException("password");
    Rfc2898DeriveBytes bytes = new Rfc2898DeriveBytes(password,new byte[0x10],0x3e8);
    salt = bytes.getSalt();
    buffer2 = bytes.getBytes(0x20);
    byte[] dst = new byte[0x31];
    System.arraycopy(salt, 0, dst, 1, 0x10);
    System.arraycopy(buffer2, 0, dst, 0x11, 0x20);
    return Base64.encodeBase64String(dst);

}
public static boolean verifyHashedPassword(String hashedPassword, String password) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    byte[] buffer4;
    if (hashedPassword == null)
        return false;
    if (password == null)
        throw new IllegalArgumentException("password");
    byte[] src = Base64.decodeBase64(hashedPassword);
    if ((src.length != 0x31) || (src[0] != 0))
       return false;
    byte[] dst = new byte[0x10];
    System.arraycopy(src, 1, dst, 0, 0x10);
    byte[] buffer3 = new byte[0x20];
    System.arraycopy(src, 0x11, buffer3, 0, 0x20);
    Rfc2898DeriveBytes bytes = new Rfc2898DeriveBytes(password,dst,0x3e8);
    buffer4 = bytes.getBytes(0x20);
    return Arrays.equals(buffer3, buffer4);



}