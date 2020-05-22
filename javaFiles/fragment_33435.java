class A {
    B[] arr = { new B(1), new B(2), new B(3), new B(4) };
    B plain = new B(99);

    private class B  {
        public int i;
        B(int i) {
            this.i = i;
        }
        @Override
        public String toString() {
            return "Hidden class B(" + i + ")";
        }

    }
}