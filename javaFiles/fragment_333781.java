import java.io.BufferedReader;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;

    public class ReadFile implements Runnable {
        private NumberWords nw;
        private Path filePath;

        public ReadFile(NumberWords nw, Path filePath) {
            this.nw = nw;
            this.filePath = filePath;
        }

        BufferedReader br1 = null;

        public void run() {
            try {
                int count = 0;
                for (String line : Files.readAllLines(filePath)) {
                    String[] parts = line.split(" ");
                    for (String w : parts) {
                        count++;
                    }
                }
                nw.incTotalWordCount(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }