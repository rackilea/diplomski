public void removeDuplicates(List<Object> l) {
    // ... the list is already populated
    Set<Object> s = new TreeSet<Object>(new Comparator<Object>() {

        @Override
        public int compare(Object o1, Object o2) {
            // ... compare the two object according to your requirements
            return 0;
        }
    });
            s.addAll(l);
    List<Object> res = Arrays.asList(s.toArray());
}