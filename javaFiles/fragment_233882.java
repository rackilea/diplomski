OutputStream outputStream = new FileOutputStream(new File("/home/input.pdf")); 
int read = 0; 
byte[] bytes = new byte[1024]; 
while ((read = inputStream.read(bytes)) != -1) { 
outputStream.write(bytes, 0, read); 
}