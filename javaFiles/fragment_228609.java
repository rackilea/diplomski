private static Reader traceReader(final Reader reader) {
    return new Reader() {
        @Override
        public int read(final char[] buffer, final int offset, final int length)
                throws IOException {
            final int read = reader.read(buffer, offset, length);
            if ( read != -1 ) {
                // or any other appropriate tracing output here
                out.print(new String(buffer, offset, read));
                out.flush();
            }
            return read;
        }

        @Override
        public void close()
                throws IOException {
            reader.close();
        }
    };
}