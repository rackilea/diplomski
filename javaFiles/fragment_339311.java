filter(list, new FilterNumber() {
    @Override
    public boolean test(Integer i) {
        return i != 1 && i != 3 && i != 7; 
    }
});