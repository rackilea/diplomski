private static class InitialedList implements Iterable<String> {

    final List<String> items;

    public InitialedList(List<String> mItems) {
        this.items = mItems;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> i = items.iterator();
            // The next from the list.
            String next = null;
            // The last one we delivered.
            String last = null;

            @Override
            public boolean hasNext() {
                return next != null || i.hasNext();
            }

            @Override
            public String next() {
                // Peek at the next.
                if (next == null) {
                    next = i.next();
                }
                // What to return.
                String it = null;
                // Is there a change in initial?
                if (next != null) {
                    // Behaviour undefined if empty string in list.
                    if (last == null || last.charAt(0) != next.charAt(0)) {
                        it = next.substring(0, 1);
                    } else {
                        it = next;
                        next = null;
                    }
                }
                return last = it;
            }

        };
    }
}

public void test() {
    List<String> mItems = new ArrayList<>();
    mItems.add("Steve Jobs");
    mItems.add("Inheritance (The Inheritance Cycle)");
    mItems.add("The Hunger Games");
    mItems.add("The LEGO Ideas Book");
    mItems.add("Catching Fire (The Second Book of the Hunger Games)");
    mItems.add("Death Comes to Pemberley");
    mItems.add("Diary of a Wimpy Kid 6: Cabin Fever");
    mItems.add("Explosive Eighteen: A Stephanie Plum Novel");
    mItems.add("Elder Scrolls V: Skyrim: Prima Official Game Guide");
    Collections.sort(mItems);
    for (String s : new InitialedList(mItems)) {
        System.out.println(s);
    }
}