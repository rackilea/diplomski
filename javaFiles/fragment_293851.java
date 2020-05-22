static class ArduinoBufferedOutputStream extends OutputStream {

        public static final int WIRE_CAPACITY = 25;
        private final ConcurrentLinkedQueue<Byte> buffer = new ConcurrentLinkedQueue<Byte>();
        private int onWire = 0;
        private OutputStream wrapped;

        public ArduinoBufferedOutputStream(final OutputStream wrapped) throws IOException {
            super();
            this.wrapped = wrapped;
        }

        @Override
        public void write(int i) throws IOException {
            this.buffer.add((byte) i);
        }

        @Override
        public void write(byte[] bytes) throws IOException {
            for (byte aByte : bytes) {
                this.buffer.add(aByte);
            }
        }

        @Override
        public void write(byte[] bytes, int off, int len) throws IOException {
            for (int i = off; i < len; i++) {
                this.buffer.add(bytes[i]);
            }
        }

        public void ping() throws IOException {
            synchronized (this.buffer) {
                this.onWire = 0;
            }
            this.flush();
        }

        @Override
        public void flush() throws IOException {
            synchronized (this.buffer) {
                for (; this.onWire < WIRE_CAPACITY && buffer.size() > 0; this.onWire++) {
                    wrapped.write(buffer.poll());
                }
            }
        }
    }