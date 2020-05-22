public void findFile(final String regExp, final String dirName) {
   try {
      final File dir = new File(dirName);

      if (dir.canRead() == false) {
         return;
      }

      final File[] files = dir.listFiles();

      for (final File file : files) {
         if (file.isFile() && file.getName().matches(regExp)) {
               System.out.println(file.getAbsolutePath());
         }
         if ((file.isDirectory()) && (file.canRead())) {
            findFile(regExp, file.getAbsolutePath());
         }
      }
   } catch (final IOException ignore) {
      System.out.println("No access to '"+dirName+"'.");
   }
}