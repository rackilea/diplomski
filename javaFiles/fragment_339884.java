class ListFactory$1 extends AbstractList {
    /*synthetic*/ final int[] val$numbers;

    ListFactory$1(/*synthetic*/ final int[] val$numbers) {
        this.val$numbers = val$numbers;
        super();
    }

    @Override()
    public Integer get(int index) {
        return Integer.valueOf(val$numbers[index]);
    }

    @Override()
    public int size() {
        return val$numbers.length;
    }

    @Override()
    /*synthetic*/ public Object get(/*synthetic*/ int index) {
        return this.get(index);
    }
}