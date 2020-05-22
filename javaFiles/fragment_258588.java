@Test
public void reuseIteratorTest() {

    class MyList implements Iterable<Text> {

        private List<String> myList = new ArrayList<>();
        private Text reused = new Text();

        public MyList() {
            myList.add("a");
            myList.add("b");
            myList.add("c");
            myList.add("d");
        }

        @Override
        public Iterator<Text> iterator() {
            return new Iterator<Text> () {

                private final Iterator<String> iter = myList.iterator();

                @Override
                public boolean hasNext() {
                    return iter.hasNext();
                }

                @Override
                public Text next() {
                    // We reuse the Text object here!
                    reused.set(iter.next());
                    return reused;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("");
                }
            };
        }
    }

    MyList myList = new MyList();
    Text first;
    Text second;

    Iterator<Text> iterator = myList.iterator();
    if (!iterator.hasNext()) return;
    first = iterator.next();
    while (iterator.hasNext()) {
        second = iterator.next();
        System.out.println("Out: " + first + " - " + second);
        first = new Text();
        first.set(second);
    }
}