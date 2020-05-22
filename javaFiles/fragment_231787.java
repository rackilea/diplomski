class Key {
        final int index;
        final int lastEl;

        Key(int index, int lastEl) {
            this.index = index;
            this.lastEl = lastEl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (index != key.index) return false;
            return lastEl == key.lastEl;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + lastEl;
            return result;
        }
    }

    public int lis(final List<Integer> a) {
        return maxIncreasing(0, Integer.MIN_VALUE, a);
    }
    HashMap<Key, Integer> memo = new HashMap<>();
    private int maxIncreasing(int index, int lastElt, final List<Integer> a) {
        Key key = new Key(index ,lastElt);
        if(memo.containsKey(key)) return memo.get(key);
        // end?
        if(index >= a.size()) return 0;
        int weTake = Integer.MIN_VALUE;
        // can we take it?
        if(a.get(index) > lastElt) {
            // take it or don't
            weTake = maxIncreasing(index + 1, a.get(index), a) + 1;
        }
        int weDoNot = maxIncreasing(index + 1, lastElt, a);
        int max = Math.max(weTake, weDoNot);
        memo.put(key, max);
        return max;
    }