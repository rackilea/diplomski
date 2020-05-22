// First write the file's length (4 bytes)
int length = (int) myFile.length();
os.write((length >>> 24) & 0xff);
os.write((length >>> 16) & 0xff);
os.write((length >>>  8) & 0xff);
os.write(length & 0xff);

// And now send the content of the file just as you did