int size = 64*1024; // 64KiB
byte[] chunk = new byte[size];
int read = -1;
for( read = s.read(chunk); read != -1; read = s.read(chunk)) {
  /*
   * I do hope you have some API call like the thing below, or at least one with a wrapper object that 
   * exposes partially filled buffers. Because read might not be the size of the entire buffer if there
   * are less than that amount of bytes available in the input stream until the end of the file...
   */
  client.postToServer(chunk, 0, read);
}