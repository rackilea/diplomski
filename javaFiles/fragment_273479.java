public InputStream chunkInputStream(File file, int pos, int count) {
    RandomAccessFile raf = new RandomAccessFile(file, "r");
    BoundedInputStream res = new BoundedInputStream(
         Channels.newInputStream(raf.getChannel().position(pos)), 
         count);
    //  res.setPropagateClose(false) ;  // INCORRECT!
    return res ;
}