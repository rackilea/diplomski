public class MyWorker extends SwingWorker<Void, String> {

    @Override
    protected void process(List<String> chunks) {
        for (String line : chunks) {
            textArea.append(line + "\n"); // display intermediate results from publish()
        }
    }

    private void startWorker() throws IOException {

        ProcessBuilder pb = new ProcessBuilder("aCmd");
        BufferedReader br = null;

        try {
            Process p = pb.start();
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                publish(line); // publish a chunk of result to process(..)
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) br.close();
        }
    }