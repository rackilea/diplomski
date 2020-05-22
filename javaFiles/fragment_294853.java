OutputStream os = ...;
byte[] data = ...;
int dataLength = data.length;
os.write(dataLength >> 24);
os.write(dataLength >> 16);
os.write(dataLength >> 8);
os.write(dataLength);
os.write(data);