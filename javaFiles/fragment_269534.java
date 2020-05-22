private void testMyDis(byte[] bytes) throws IOException {
    final long time1 = System.nanoTime();
    long c = 0;
    try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
        final MyDataInputStream dis = new MyDataInputStream(bais);
        for (int i = 0; i < bytes.length; i++) {
            c += dis.readByte();
        }
    }
    final long time2 = System.nanoTime();
    System.out.println("My Dis: \t\t\t" + (time2 - time1) + "\t\t\t\t" + c);
}