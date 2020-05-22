enum Foo {
    CONSTANT {
        public String toString() {
            return name().toUpperCase();
        }
    }
}