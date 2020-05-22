public static IntConsumer every(int count, IntConsumer consumer) {
    if (count <= 0)
        throw new IllegalArgumentException("Count must be >1: Got " + count);
    return new IntConsumer() {
        private int i;
        @Override
        public void accept(int value) {
            if (++this.i == count) {
                consumer.accept(value);
                this.i = 0;
            }
        }
    };
}