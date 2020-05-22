public static void copy(String fileOutName, boolean append){
    File fileOut = new File (fileOutName);

    try {
         FileChannel wChannel = new FileOutputStream(fileOut, append).getChannel();

         int i = 5;
         ByteBuffer bb = ByteBuffer.allocate(4);
         bb.order(ByteOrder.LITTLE_ENDIAN);
         bb.putInt(i);

         bb.flip();

         int written = wChannel.write(bb);
         System.out.println(written);    

         wChannel.close();
     } catch (IOException e) {
// this is the new line of code
         e.printStackTrace();
     }
}