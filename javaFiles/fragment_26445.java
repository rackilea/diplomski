public class Test
{
    public static void main(String[] args) throws Exception {
        String filePath = "D:/temp/file";
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        FileChannel chan = file.getChannel();
        try {
            MappedByteBuffer buffer = chan.map(FileChannel.MapMode.READ_WRITE, 0, 128);

            // Do something
            buffer.putInt(4);
            buffer.force();
            Cleaner cleaner = ((sun.nio.ch.DirectBuffer) buffer).cleaner();
            if (cleaner != null) {
                cleaner.clean();
            }
        } finally {
            chan.close();
            file.close();
            System.out.println("File closed");
        }

        System.out.println("Press any key...");
        System.in.read();

        System.out.println("Finished");
    }
}