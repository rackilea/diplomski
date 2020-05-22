public class FileMerger {

    private volatile int currentWriterId = 0;

    public static void main(String[] args) throws Exception {
        // 1st argument: target directory.
        File directory = new File(args[0]);
        // 2nd argument: merge files suffix.
        FilenameFilter filter = (dir, name) -> name.endsWith("." + args[1]);

        new FileMerger().merge(directory, filter);
    }

    public void merge(File directory, FilenameFilter filter) throws IOException, InterruptedException {
        File[] files = directory.listFiles(filter);
        int numberOfFiles = files.length;
        Path mergeFilePath = Paths.get(directory.getPath() + FileSystems.getDefault().getSeparator() + "merge.txt");
        Vector<String> fileContents = new Vector<>(Collections.nCopies(numberOfFiles, null));

        Files.createFile(mergeFilePath);

        for (int i = 0; i < numberOfFiles; i++) {
            final int writerId = i;
            File file = files[i];
            CountDownLatch readWriteLatch = new CountDownLatch(1);

            // Reader.
            new Thread(() -> {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
                    String content = String.join("\n", lines);

                    fileContents.set(writerId, content);
                    readWriteLatch.countDown();
                } catch (IOException e) { /* NOP */ }
            }).start();

            // Writer.
            new Thread(() -> {
                try {
                    // Wait for corresponding reader to set content.
                    readWriteLatch.await();

                    // Wait for writer ID.
                    synchronized (this) {
                        while (currentWriterId != writerId) {
                            wait();
                        }
                        Files.write(mergeFilePath, (fileContents.get(writerId) + "\n").getBytes(), StandardOpenOption.APPEND);
                        currentWriterId++;
                        notifyAll();
                    }
                } catch (InterruptedException | IOException e) { /* NOP */ }
            }).start();
        }
    }

}