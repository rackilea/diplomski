public void doIt() throws FileNotFoundException, IOException {
    File file = new File("myfile");
    RandomAccessFile raf = new RandomAccessFile(file, "rw");
    FileChannel fc = raf.getChannel();      
    MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, file.length());

    //get a random byte
    byte b1 = mbb.get(SOME_RANDOM_BYTE); 

    //get another random byte
    mbb.position(SOME_OTHER_BYTE_POSITION);
    byte b2 = mbb.get();
}