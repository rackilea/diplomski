try {
    RandomAccessFile raf = new RandomAccessFile("ClassList.dat", "r");
    while (raf.getFilePointer() < raf.length()) {
        System.out.println(raf.readUTF());
        System.out.println(raf.readInt());
        System.out.println(raf.readDouble());
        System.out.println(raf.readDouble());
        System.out.println(raf.readDouble());
    }
    raf.close();
} catch (Exception e) {
    e.printStackTrace();
}