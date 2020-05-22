public enum TestEnum {
    AA(1000), BB(500), CC(100) {

        @Override
        public int getI() {
            return super.getI() - 1;
        }
    };

    private int i;

    TestEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }
}