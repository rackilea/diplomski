public Stream<String> lines() {
    Iterator<String> iter = new Iterator<String>() {
        String nextLine = null;

        @Override
        public boolean hasNext() {
            if (nextLine != null) {
                return true;
            } else {
                try {
                    nextLine = readLine();
                    return (nextLine != null);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
        }

        @Override
        public String next() {
            if (nextLine != null || hasNext()) {
                String line = nextLine;
                nextLine = null;
                return line;
            } else {
                throw new NoSuchElementException();
            }
        }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
            iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
}