public interface Consumer {
    public void consume(String text);
}

public class ExecuteWorker extends SwingWorker<String, String> {

    private String can, pad, pathfile;
    private Consumer consumer;

    public ExecuteWorker(Consumer consumer, String can, String pad, String pathfile) {
        this.can = can;
        this.pad = pad;
        this.pathfile = pathfile;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String text : chunks) {
            consumer.consume(text);
        }
    }

    @Override
    protected String doInBackground() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("testpad", "-i", "-c" + can, "-n" + pad, pathfile);
        pb.redirectErrorStream(true);

        StringJoiner sj = new StringJoiner("\n");
        Process p = pb.start();
        try (InputStreamReader reader = new InputStreamReader(p.getInputStream());
                Scanner scan = new Scanner(reader)) {

            while (scan.hasNextLine()) {
                String text = scan.nextLine();
                System.out.println(text);
                publish(text);
                sj.add(text);

            }

        }
        return sj.toString();
    }

}