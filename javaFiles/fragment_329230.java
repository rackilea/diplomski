DataInputStream dis = new DataInputStream(new FileInputStream("my-data-file.dat"));
 try {
     byte[] bytes = new byte[128];
     dis.readFully(bytes);
     // read some more.

 } finally {
     try {
        dis.close();
     } catch(IOException ignored) { }
 }