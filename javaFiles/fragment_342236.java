public Iterable<String> eachOnce() {
    List<String> allResults = new ArrayList<String>();
    // fill list
    return allResults;
}

public Iterable<String> eachCyclic() {
    return new Iterable<String>() {

        public Iterator<String> iterator() {
            return new Iterator<String>() {

                public boolean hasNext() {
                    return true;
                }

                public String next() {
                    // TODO implement
                    return null;
                }

                public void remove() {
                    // do nothing
                }
            };

        }
    };
}