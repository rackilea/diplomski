class Outer {

    private int innerCount;

    class Inner() {
        private final Outer owner;

        public Inner(Outer owner) {
            this.owner = owner;
            this.owner.innerCount++;
        }
    }

    private void multiply() {
        Inner inner = new Inner(this);
        ...
    }
}