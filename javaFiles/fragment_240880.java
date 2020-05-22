final Enumeration<ByteArrayInputStream> basEnum = new Enumeration<ByteArrayInputStream>() {

    ByteArrayInputStream baos;
    boolean ended;

    @Override
    public boolean hasMoreElements() {
        if (ended) {
            return false;
        }

        if (baos == null) {
            getNextBA();
            if (ended) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ByteArrayInputStream nextElement() {
        if (ended) {
            throw new NoSuchElementException();
        }
        if (baos.available() != 0) {
            return baos;
        }

        getNextBA();
        return baos;
    }

    private void getNextBA() {

        byte[] next;
        try {
            next = byteReader.read();
        } catch (IOException e) {
            throw new IllegalStateException("Issues reading byte arrays");
        }
        if (next == null) {
            ended = true;
            return;
        }
        this.baos = new ByteArrayInputStream(next);
    }
};

SequenceInputStream sis = new SequenceInputStream(basEnum);