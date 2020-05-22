class SomeClass {
    private InnerClass {
        public void foo() {
            SomeClass outerThis = SomeClass.this;
            [...]
        }
    }
}