public class MergeFiles<T extends Comparable<T>> {
    private final PriorityQueue<ComparableFile<T>> files;

    public MergeFiles(List<File> files, Deserializer<T> deserializer) {
        this.files = new PriorityQueue<>(files.stream()
                .map(file -> new ComparableFile<>(file, deserializer))
                .filter(comparableFile -> !comparableFile.isEmpty())
                .collect(toList()));
    }

    public Iterator<T> getSortedElements() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !files.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                ComparableFile<T> head = files.poll();
                T next = head.pop();
                if (!head.isEmpty()) files.add(head);
                return next;
            }
        };
    }
}