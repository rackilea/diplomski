class Sum implements Visitor<Integer> {
    private int sum = 0;

    @Override
    public void visit(Integer element) {
        sum += element.intValue();
    }

    public int value() {
        return sum;
    }
}