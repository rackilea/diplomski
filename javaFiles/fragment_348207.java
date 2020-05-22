int dataLength = (int) file.length();
byte fileContent[] = new byte[dataLength];
bis.read(fileContent);
dos.writeInt(dataLength);
dos.write(fileContent);
dos.flush();
dataLength -= n;