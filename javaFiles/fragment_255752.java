public class Test {
    public static final Charset ENCODING = Charset.forName("UTF-8");
    public static final byte[] NEWLINE_BYTES = {0x0A, 0x0D};

    public Test() {
        //test text file sequence of any strings followed by newline
        String pathString = "test.txt";
        Path path = Paths.get(pathString);

        try (FileChannel fc = FileChannel.open(path, 
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            if (fc.size() > 0) {
                int n;
                ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());
                do {                    
                    n = fc.read(buffer);
                } while (n != -1 && buffer.hasRemaining());
                buffer.flip();
                int newlineByteCount = 0;
                buffer.mark();
                do {
                    //get one byte at a time
                    byte b = buffer.get();

                    if (b == NEWLINE_BYTES[0] || b == NEWLINE_BYTES[1]) {
                        newlineByteCount++;

                        byte nextByte = buffer.get();
                        if (nextByte == NEWLINE_BYTES[1]) {
                            newlineByteCount++;
                        } else {
                            buffer.position(buffer.position() - 1);
                        }

                        int pos = buffer.position();
                        //reset the buffer back to the mark() position
                        buffer.reset();
                        //create an array just the right length and get the bytes we just measured out 
                        int length = pos - buffer.position() - newlineByteCount;
                        byte[] lineBytes = new byte[length];
                        buffer.get(lineBytes, 0, length);

                        String lineString = new String(lineBytes, ENCODING);
                        System.out.println("LINE: " + lineString);

                        buffer.position(buffer.position() + newlineByteCount);

                        buffer.mark();
                        newlineByteCount = 0;
                    } else if (newlineByteCount > 0) {

                    }
                } while (buffer.hasRemaining());
            } 
        } catch (IOException ioe) { ioe.printStackTrace(); }
    }
    public static void main(String args[]) { new Test(); }
}