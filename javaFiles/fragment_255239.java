public static void main(String[] xxx) {
    System.setOut(new DoublePrintStream(System.out, "/myfile.txt"));
    System.setErr(new DoublePrintStream(System.err, "/errors.txt"));

    System.out.println("this works");
    try { throw new RuntimeException("oulala");} catch(Exception e) { e.printStackTrace(); }

    //System.out.close(); // maybe required at the end of execution
}

class DoublePrintStream extends PrintStream {
        private final OutputStream fos;

        DoublePrintStream(OutputStream out, String filename){
            super(out);

            try {
                fos = new FileOutputStream(new File(filename));
            } catch (FileNotFoundException e) {
                throw new AssertionError("cant create file", e);
            }
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            super.write(buf, off, len);

            try {
                fos.write(buf, off, len);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void close() {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                super.close();
            }
        }
    }