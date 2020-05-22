List<byte[]> filecontents = new ArrayList<byte[]>();
  InputStream is = new FileInputStream(...);
  byte[] buffer = new byte[MAX_BUFFER_SIZE];
  int bytesGot = readUpToMaxBufferSizeFrom(file);
  while(bytesGot != -1) {
       byte[] chunk = new byte[bytesGot];
       System.arrayCopy(buffer, 0, chunk, 0, bytesGot);
       filecontents.add(chunk);
  }