private class Processor implements Runnable {
    private final File file;

    public Processor(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        Data d = readFile(file);
        ProcessedData p = d.process();
        writeFile(p,file.getAbsolutePath(),outputDir);
    }
}

private void crawlDirectoryAndProcessFiles(File directory, Executor executor) {
    for (File file : directory.listFiles()) {
        if (file.isDirectory()) {
          crawlDirectoryAndProcessFiles(file,executor);
        } else {
            executor.execute(new Processor(file); 
        }
    }
}