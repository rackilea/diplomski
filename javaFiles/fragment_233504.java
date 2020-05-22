bis=new BufferedInputStream(sock.getInputStream());
 fos = new FileOutputStream(file);
 int n;
 byte[] buffer = new byte[8192];
 while ((n = bis.read(buffer)) > 0){
 fos.write(buffer, 0, n);}