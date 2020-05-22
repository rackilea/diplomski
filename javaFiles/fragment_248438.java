public class FileReaderWorker extends SwingWorker<List<String>, String> {

    private final File inFile;
    private final JTextArea output;

    public FileReaderWorker(File file, JTextArea output) {
        inFile = file;
        this.output = output;
    }

    public File getInFile() {
        return inFile;
    }

    public JTextArea getOutput() {
        return output;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String line : chunks) {
            output.append(line);
        }
    }

    @Override
    protected List<String> doInBackground() throws Exception {
        List<String> lines = new ArrayList<String>(25);
        java.io.File cpFile = getInFile();
        if (cpFile != null && cpFile.exists() == true) {
            File file = cpFile;

            BufferedReader br = null;

            String strLine = "";
            String logPrint = "";
            try {
                // New Buffer Reader
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while ((strLine = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(strLine, ";");
                    while (st.hasMoreTokens()) {
                        logPrint = st.nextToken();
                        publish(logPrint);
                    }
                }
            } catch (Exception e) {
                publish("Failed read in file: " + e);
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (Exception e) {
                }
            }
        } else {
            publish("Input file does not exist/hasn't not begin specified");
        }            
        return lines;
    }
}