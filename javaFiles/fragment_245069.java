class ScriptRunner implements Runnable {

    private String thread;

    ScriptRunner(String thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            ProcessBuilder ps = new ProcessBuilder("py", "test.py", thread);
            ps.redirectErrorStream(true);
            Process pr = ps.start();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}