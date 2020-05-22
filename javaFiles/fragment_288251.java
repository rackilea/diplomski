InputStream is = uploadedFile.getInputStream();
 byte[] buffer = new byte[uploadedFile.getLength()); //This can be more space-efficient if necessary
 is.read(buffer);
 File f = new File("C:\\tmp\\" + uploadedFile.getFilename());
 f.createNewFile();
 FileOutputStream fos = new FileOutputStream(f);
 fos.write(buffer);