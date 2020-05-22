File dir = new File("foo");
if (dir.exists()) {
   if (dir.listFiles() == null) {
      // directory not readable
   }
}