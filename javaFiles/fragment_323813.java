public static void main(String[] args) throws Exception {
    String pass = "pass123";
    byte[] message = pass.getBytes();
    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
    messageDigest.update(message);
    byte[] md = messageDigest.digest();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < md.length; i++) {
        sb.append(Integer.toString((md[i] & 0xff) + 0x100, 16).substring(1));
    }
    System.out.println("encoded pass:" + sb.toString());
    System.out.println(sb.toString().equals("aafdc23870ecbcd3d557b6423a8982134e17927e"));
}