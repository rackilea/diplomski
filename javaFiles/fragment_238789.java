final List<Integer> values = Arrays.asList(2,5);
Iterator<Integer> filteredIterator = new FilterIterator(yourIterator, new Predicate<Integer>() {
    public boolean evaluate(Integer object) {
        return values.contains(object);
    }        
});