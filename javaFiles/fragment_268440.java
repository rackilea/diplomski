public static void main(String[] args) {
     RijndaelEncryption s = new RijndaelEncryption();
     byte[] salt = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
     String encryptStr = s.encryptString("763059", "515t3ma5m15B4d35", salt, 1000, 256, 128);
     System.out.println("Encryptation: " + encryptStr);
}