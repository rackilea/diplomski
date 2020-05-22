public class URLWorker extends SwingWorker<List<String>, String> {

    private List<String> urls;
    private BufferedWriter bw;

    public URLWorker(List<String> urls, BufferedWriter bw) {
        this.urls = urls;
        this.bw = bw;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String result : chunks) {

            try {
                bw.write(result);
                bw.newLine();
            } catch (IOException exp) {
                firePropertyChange("error", null, ex);
            }

        }
        try {
            bw.flush();
        } catch (IOException ex) {
            firePropertyChange("error", null, ex);
        }
    }

    @Override
    protected List<String> doInBackground() throws Exception {
        List<String> results = new ArrayList<String>(urls.size());
        for (final String s : urls) {
            String sContent = IO.getURLContent(s);
            StringBuilder result = new StringBuilder(s);
            if (sContent == null) {
                result.insert(0, "Error ");
            } else {
                result.insert(0, "Worked ");
            }
            publish(result.toString());
            results.add(result.toString());
        }
        return results;
    }
}