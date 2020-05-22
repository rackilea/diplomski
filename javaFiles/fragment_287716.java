Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
    List<Integer> empty = asList();
    Iterator<Integer> iter = new MergingIterator<Integer> (
        cmp,
        asList(1, 2, 4, 5, 7, 8),
        asList(3),
        asList(6, 9),
        asList(0),
        empty
    );

    while (iter.hasNext()) {
        System.out.println(iter.next());
    }