File file = new File(/*file path*/);
byte[] bFile = new byte[1000];

RandomAccessFile fileInputStream = new RandomAccessFile(file, "r");
fileInputStream.seek(fileInputStream.length() - bFile[0].length);
fileInputStream.read(bFile, 0, bFile.length);
fileInputStream.close();