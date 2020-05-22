public class MyHashTable {

    private class HashTableIterator implements MyIterator {

        // HashTableIterator fields

        // HashTableIterator contructor

        public Object next() {
            // Implementation of next()
        }

        public boolean hasNext() {
            // Implementation of hasNext()
        }
    }

    // MyHashTable fields

    // MyHashTable constructor(s)

    // MyHashTable methods

    public MyIterator iterator() {
        return new HashTableIterator();
     }

}