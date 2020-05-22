Stream.of(1,2,3).forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer i) {
        return true; // you can correlate easily now why this wouldn't compile 
    }
});  // DOES NOT COMPILE!