class CollectorOfAnything implements Consumer<Object> {
    private List<Object> myCollection = new ArrayList<>();

    @Override
    public void accept(Object anything) {
        myCollection.add( anything );
    }
}