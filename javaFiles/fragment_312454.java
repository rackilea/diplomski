public class Trie<E> implements Collection<E> {

    private Comparator<? super E> comparator;

    private class Entry {
        private Entry parent;
        private Set<Entry> children;

        private E data;

        Entry(Entry parent, E data) {
            this.parent = parent;
            this.data = data;

            parent.addChild(this);
        }

        boolean addChild(Entry child) {
            if (children == null)
                children = new TreeSet<Entry>(new Comparator<Entry>() {
                    public int compare(Entry o1, Entry o2) {
                        return Trie.this.comparator.compare(o1.data, o2.data);
                    };
                });

            return children.add(child);
        }

        boolean removeChild(Entry child) {
            boolean result = false;
            if (children != null && children.contains(child)) {
                result = children.remove(child);
                if (children.size() == 0)
                    children = null;
            }
            return result;
        }
    }
}