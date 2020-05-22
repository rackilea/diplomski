RandomAccessFile file = new RandomAccessFile("D:\\test.txt", "rw");
int totalLines = (int)file.length();
file.seek(100);
long pointer = file.getFilePointer();


for(int pt = 100; ct < totalLines; ct++){
  byte b = file.readByte(); //read byte from the file
  System.out.print((char)b); //convert byte into char
}

file.close();