try {
   FileOutputStream out = new FileOutputStream(file);
   try {
       FileChannel ch = out.getChannel();
       ch.position(offset);
       ch.write(ByteBuffer.wrap(data));
   } finally {
       out.close();
   } 
} catch (IOException ex) {
    // handle error
}