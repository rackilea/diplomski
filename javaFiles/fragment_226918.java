private static String hashMyString(String text)  {

    String hashText= text;

    String md5Hex = DigestUtils
      .md5Hex(hashText).toUpperCase();

   return md5Hex;
}