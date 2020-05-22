static class PipeFeederThread extends Thread {
    InputStream in;
    OutputStream out;

    PipeFeederThread(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        byte[] buf = new byte[8192];
        int len;

        try {
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            Log.e(TAG, "PipeFeederThread: Data transfer failed:", e);
        }
    }
}