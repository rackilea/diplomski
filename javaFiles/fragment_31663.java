public static String encode(String strs,String key_plain, String algorithm) {
   if (algorithm.equals("no-encryption")){ //maybe use an enum?
      return strs;
   }
   ...
}