bos= new BufferedOutputStream(sock.getOutputStream());
 FileInputStream fis = new FileInputStream(file);
 BufferedInputStream bis = new BufferedInputStream(fis);
 int n=-1;
 byte[] buffer = new byte[8192];
 while((n = bis.read(buffer))>-1) 
 bos.write(buffer,0,n);