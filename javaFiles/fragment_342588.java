class IntConsumerAdapter implements Consumer<Integer>, IntConsumer {

    @Override
    public void accept(Integer value) {
        accept(value.intValue());
    }

    @Override
    public void accept(int value) {
        // todo
    }
}