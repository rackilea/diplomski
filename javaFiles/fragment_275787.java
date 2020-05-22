public class StreamGobbler implements Runnable {
    private InputStream in;
    public StreamGobbler(InputStream in) {
        this.in = in;
    }
    @Override
    public void run() {
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                // could log it here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}