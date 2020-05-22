int blockSize = XXX;
byte[] buffer = new byte[blockSize];
int i = 0;
int read = in.read(buffer);
while(read != -1) {
   out[i++].write(buffer, 0, read);
   read = in.read(buffer);
}