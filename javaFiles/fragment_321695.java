public static String toString(byte[] bytes) {
  try {
    String s = new String(bytes ,"UTF-8");
     return s;
     } catch (UnsupportedEncodingException e) {
      return null;
     }
  }