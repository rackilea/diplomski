public class ComparableFile<T extends Comparable<T>> implements Comparable<ComparableFile<T>> {
    private final Deserializer<T> deserializer;
    private final Iterator<String> lines;
    private T buffered;

    public ComparableFile(File file, Deserializer<T> deserializer) {
        this.deserializer = deserializer;
        try {
            this.lines = Files.newBufferedReader(file.toPath()).lines().iterator();
        } catch (IOException e) {
            // deal with it differently if you want, I'm just providing a working example
            // and wanted to use the constructor in a lambda function
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public int compareTo(ComparableFile<T> that) {
        T mine = peek();
        T theirs = that.peek();

        if (mine == null) return theirs == null ? 0 : -1;
        if (theirs == null) return 1;
        return mine.compareTo(theirs);
    }

    public T pop() {
        T tmp = peek();

        if (tmp != null) {
            buffered = null;
            return tmp;
        }

        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return peek() == null;
    }

    private T peek() {
        if (buffered != null) return buffered;
        if (!lines.hasNext()) return null;
        return buffered = deserializer.deserialize(lines.next());
    }
}