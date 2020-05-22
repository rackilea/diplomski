int FILE_SIZE = 60000000; //just a large size
int current = 0;
byte[] pdf = new byte[FILE_SIZE];
InputStream is = s.getInputStream();
File someFile = new File(getCacheDir() + "/file.pdf");
FileOutputStream fos = new FileOutputStream(someFile);
BufferedOutputStream bos = new BufferedOutputStream(fos);
int bytesRead = 0;
int b;
while ((b = is.read()) != -1) {
   bos.write(b);
   bytesRead++;
}
bos.flush();
bos.close();
fos.close();