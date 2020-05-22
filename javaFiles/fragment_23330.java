public enum Example {
    HELLO(R.string.hello),
    WORLD(R.string.world);

    private int mResourceId;

    private Example(int id) {
        mResourceId = id;
    }

    @Override
    public String toString() {
        return App.getContext().getString(mResourceId);
    }
}