public class ProcessReader extends Thread {
    private Process p;

    public ProcessReader(Process p) {
        this.p = p;
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        try {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}