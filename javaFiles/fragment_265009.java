public static void decryptFile(InputStream outFileIn, InputStream privKeyStream, char[] passPhrase, String outFileName) {
    // ----- Decrypt the file

    try {

        ByteBuffer buf = ByteBuffer.allocate(1024 * 10);
        byte[] read = new byte[1024];

        while (outFileIn.read(read, 0, 1024) != -1) {
            buf.put(read);
        }

        BASE64Encoder en = new BASE64Encoder();
        String temp = en.encode(buf.array());
        // System.out.println("Temp: " + temp);

        byte[] newB = null;
        BASE64Decoder en1 = new BASE64Decoder();
        try {
            newB = en1.decodeBuffer(temp);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(newB);
        decryptIt(bais, privKeyStream, passPhrase, outFileName);

    } catch (Exception e1) {

        e1.printStackTrace();
    }

}