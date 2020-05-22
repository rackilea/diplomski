Stream.of(1,2,3).forEach(new Consumer<Integer>() {
    @Override
    public void accept(Integer i) {
        list.add(1); // ignored return type
    }
});  // COMPILES