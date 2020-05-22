class StreamUtils {
    public static<T> Stream<List<T>> sliding(int size, Stream<T> stream) {
        return sliding(size, 1, stream);
    }

    public static<T> Stream<List<T>> sliding(int size, int step, Stream<T> stream) {
        Spliterator<T> spliterator = stream.spliterator();
        long estimateSize;

        if (!spliterator.hasCharacteristics(Spliterator.SIZED)) {
            estimateSize = Long.MAX_VALUE;
        } else if (size > spliterator.estimateSize()) {
            estimateSize = 0;
        } else {
            estimateSize = (spliterator.estimateSize() - size) / step + 1;
        }

        return StreamSupport.stream(
                new Spliterators.AbstractSpliterator<List<T>>(estimateSize, spliterator.characteristics()) {
                    List<T> buffer = new ArrayList<>(size);

                    @Override
                    public boolean tryAdvance(Consumer<? super List<T>> consumer) {
                        while (buffer.size() < size && spliterator.tryAdvance(buffer::add)) {
                            // Nothing to do
                        }

                        if (buffer.size() == size) {
                            List<T> keep = new ArrayList<>(buffer.subList(step, size));
                            consumer.accept(buffer);
                            buffer = keep;
                            return true;
                        }
                        return false;
                    }
                }, stream.isParallel());
    }
}