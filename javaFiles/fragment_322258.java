class LogAnalyzer {
    private final File logFile;

    LogAnalyzer(File logFile) {
        this.logFile = logFile;
    }

    void analyze() throws IOException {
        try(FileReader fileReader = new FileReader(logFile)) {
            try(BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    analyzeLine(line);
                }
            }
        }
    }

    private void analyzeLine(String line) {
        // do whatever you need here
    }
}