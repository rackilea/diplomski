public String getUserHtmlContentPath() {

   File temp = File.createTempFile("userContent", ".tmp");
   temp.deleteOnExit();

   FileWriter fw = new FileWriter(temp);
   fw.write(getUserHtmlContentComposition());
   fw.close();

   return "file://" + temp.getAbsolutePath(); 
}