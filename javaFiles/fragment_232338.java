private void redirectOutputStreamsToConsole(Process process) {
    redirectStream(process.getInputStream(), System.out);
    redirectStream(process.getErrorStream(), System.err);
}

private void redirectStream(final InputStream in, final PrintStream out) {
    new Thread() {
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while ((line = reader.readLine()) != null)
                    out.println(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }.start();
}