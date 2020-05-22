import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Iterator;

public class DesignPatterns {

    public static void main(String[] args) {
        Pair<String, String> pair = new ImmutablePair("A", "B");
        for (String item : new PairIterableAdapter<>(pair)) {
            System.out.println(item);
        }
    }
}

class PairIterableAdapter<T> implements Iterable<T> {

    private final Pair<T, T> pair;

    public PairIterableAdapter(Pair<T, T> pair) {
        this.pair = pair;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int counter = 2;

            @Override
            public boolean hasNext() {
                return counter-- > 0;
            }

            @Override
            public T next() {
                switch (counter) {
                    case 1:
                        return pair.getLeft();
                    case 0:
                        return pair.getRight();
                    default:
                        throw new IndexOutOfBoundsException("No more elements!");
                }
            }
        };
    }
}