public InputStream foo(int i) {
   final String s = String.valueOf(i);
   boolean b = s.length() > 3;
   File dir;
   if (b) {
       dir = new File("C:/tmp");
   } else {
       dir = new File("/tmp");
   }
   if (!dir.exists()) dir.mkdirs();
   return new FileInputStream(new File(dir, "hello.txt"));
}