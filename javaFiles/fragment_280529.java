MappedByteBuffer mem =
  new RandomAccessFile("/tmp/mapped.txt", "rw").getChannel()
  .map(FileChannel.MapMode.READ_WRITE, 0, 1);

while(true){
  while(mem.get(0)!=5) Thread.sleep(0); // waiting for client request
  mem.put(0, (byte)10); // sending the reply
}