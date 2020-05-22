class DataForwarder extends Thread {

    OutputStream out;
    InputStream in;

    public DataForwarder(InputStream in, OutputStream out) {
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {
        byte[] buf = new byte[1024];
        System.out.println("Hej");
        try {
            int n;
            while (-1 != (n = in.read(buf)))
                out.write(buf, 0, n);
            out.close();
        } catch (IOException e) {
            // Handle in some suitable way.
        }
    }
}