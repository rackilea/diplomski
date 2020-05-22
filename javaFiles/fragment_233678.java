public static Iterable<Integer> getCodePoints(final String text) {
    return new Iterable<Integer>() {
        @Override public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private int nextIndex = 0;

                @Override public boolean hasNext() {
                    return nextIndex < text.length();
                }

                @Override public Integer next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    int codePoint = text.codePointAt(nextIndex);
                    nextIndex += Character.charCount(codePoint);
                    return codePoint;
                }

                @Override public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    };
}