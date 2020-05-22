import java.io.IOException;
        import java.io.RandomAccessFile;
        import java.nio.channels.FileChannel;

        public class ReadFromFile {

            /**
             * @param args
             * @throws IOException
             */
            public static void main(String[] args) throws IOException {

                Runnable runnable = new Runnable() {

                    //it's your choice how will you close the channel
                    FileChannel in = null;

                    @Override
                    public void run() {
                        long lastChannelPos = 0L;
                        try {
                            /*
                             *I assume you will run it forever
                             *if you don't want to run it forever
                             *put a condition over here in the while loop.
                            */
                            while (true) {
                                RandomAccessFile raf = new RandomAccessFile(
                                        "your_file_loc", "r");
                                raf.seek(lastChannelPos);
                                int c = 0;
                                StringBuffer sb = new StringBuffer();
                                while ((c = raf.read()) != -1) {
                                    sb.append((char) c);
                                }
                                in = raf.getChannel();
                                lastChannelPos = in.position();

                                if (!sb.toString().trim().isEmpty()) {
                                    //you can print or use the output as you wish
                                    //for simplicity I'm printing it 
                                    System.out.print(sb.toString().trim());
                                }
                                Thread.sleep(1000);
                                raf.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                };

                Thread th = new Thread(runnable);
                th.start();             
}