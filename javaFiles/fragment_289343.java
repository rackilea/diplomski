public void myMethod() {
   try {
      ...
      String encodedString = URLEncoder.encode(foo, "utf-8");
       ...
   } catch(UnsupportedEncodingException e) {
     throw new RuntimeException("This should not be possible",e);
   }

}