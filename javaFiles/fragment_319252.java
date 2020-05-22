public class ProcessWorker extends SwingWorker<Boolean, Void> {
    public Boolean doInBackground() throws Exception {
        ProcessBuilder pb = new ProcessBuilder(...);
        Process p = pb.start();
        // Read the input stream in separate thread...
        return p.waitFor() == 0;
    }

    public void done() {
        try {
            boolean okay = get();
            if (!okay) {
                // Re-run....?
            }
        } catch (Exception exp) {
            // Show error message, maybe in a JOptionPane
        }
    }
}