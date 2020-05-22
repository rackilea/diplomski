OutputStream bos = null;
InputStream stream = null;
try {
  String fileName = form.getImage().getFileName();
  String directory = "C:/your_folder";
  File f = new File(directory);
   if (!f.exists()) {
    f.mkdir();

   if (!"".equals(fileName)) {
    stream = form.getImage1().getInputStream();
    bos = new FileOutputStream(directory + fileName);
    int bytesRead = 0;
     byte[] buffer = new byte[8192];

     while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
      bos.write(buffer, 0, bytesRead);
     }
    }
   }
} catch (Exception e) {
 e.printStackTrace();
}