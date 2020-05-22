public class LongIntParallelHashMultimap {

    private static final long NULL = 0L;

    private final long[] keys;
    private final int[] values;
    private int size;

    public LongIntParallelHashMultimap(int capacity) {
        keys = new long[capacity];
        values = new int[capacity];
    }

    public void put(long key, int value) {
        if (key == NULL) throw new IllegalArgumentException("key cannot be " + NULL);
        if (size == keys.length) throw new IllegalStateException("map is full");

        int index = indexFor(key);
        while (keys[index] != NULL) {
            index = successor(index);
        }
        keys[index] = key;
        values[index] = value;
        ++size;
    }

    public int[] get(long key) {
        if (key == NULL) throw new IllegalArgumentException("key cannot be " + NULL);

        int index = indexFor(key);
        int count = countHits(key, index);

        int[] hits = new int[count];
        int hitIndex = 0;

        while (keys[index] != NULL) {
            if (keys[index] == key) {
                hits[hitIndex] = values[index];
                ++hitIndex;
            }
            index = successor(index);
        }

        return hits;
    }

    private int countHits(long key, int index) {
        int numHits = 0;
        while (keys[index] != NULL) {
            if (keys[index] == key) ++numHits;
            index = successor(index);
        }
        return numHits;
    }

    private int indexFor(long key) {
        // the hashing constant is (the golden ratio * Long.MAX_VALUE) + 1
        // see The Art of Computer Programming, section 6.4
        // the constant has two important properties:
        // (1) it is coprime with 2^64, so multiplication by it is a bijective function, and does not generate collisions in the hash
        // (2) it has a 1 in the bottom bit, so it does not add zeroes in the bottom bits of the hash, and does not generate (gratuitous) collisions in the index
        long hash = key * 5700357409661598721L;
        return Math.abs((int) (hash % keys.length));
    }

    private int successor(int index) {
        return (index + 1) % keys.length;
    }

    public int size() {
        return size;
    }

}