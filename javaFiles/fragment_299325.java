int len = 1;
int offset = 0;
byte[] data = new byte[512];
createFile();
pub_f.seek(0L); // <---- set the file pointer back to the start of the file.
readFile(offset, len, data);