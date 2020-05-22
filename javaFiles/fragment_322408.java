@SuppressWarnings("resource")
public class ThreadFileOutput extends PrintStream {

    private static ThreadLocal<FileOutputStream> threadOutput = new ThreadLocal<>();
    private static PrintStream stdout = System.out;
    private static PrintStream stderr = System.err;

    static {
        System.setOut(new ThreadFileOutput(stdout));
        System.setErr(new ThreadFileOutput(stderr));
    }

    public ThreadFileOutput(OutputStream out) {
        super(out);
    }

    public static void startThreadOutputRedirect(FileOutputStream stream) {
        threadOutput.set(stream);
    }

    public static void stopThreadOutputRedirect() {
        FileOutputStream stream = threadOutput.get();
        if (stream != null) {
            threadOutput.set(null);
            try {
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void forceOut(String line) {
        stdout.println(line);
    }

    public static void forceErr(String line) {
        stderr.println(line);
    }

    @Override
    public void write(byte[] b) throws IOException {
        FileOutputStream stream = threadOutput.get();
        if (stream != null) {
            try {
                stream.write(b);
            } catch (IOException e) {
                threadOutput.set(null);
                throw new RuntimeException(e);
            }
        } else {
            super.write(b);
        }
    }

    @Override
    public void write(int b) {
        FileOutputStream stream = threadOutput.get();
        if (stream != null) {
            try {
                stream.write(b);
            } catch (IOException e) {
                threadOutput.set(null);
                throw new RuntimeException(e);
            }
        } else {
            super.write(b);
        }
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        FileOutputStream stream = threadOutput.get();
        if (stream != null) {
            try {
                stream.write(buf, off, len);
            } catch (IOException e) {
                threadOutput.set(null);
                throw new RuntimeException(e);
            }
        } else {
            super.write(buf, off, len);
        }
    }

    @Override
    public void flush() {
        FileOutputStream stream = threadOutput.get();
        if (stream != null) {
            try {
                stream.flush();
            } catch (IOException e) {
                threadOutput.set(null);
                throw new RuntimeException(e);
            }
        } else {
            super.flush();
        }
    }
}