RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
FileChannel channel = raf.getChannel();

// .. do locking here ...

// wrap DataInputStream around existing, locked connection
DataInputStream dis = new DataInputStream(new FileInputStream(raf.getFD()));
System.out.println("Data: " + dis.readLine());

// .. do unlocking here ...