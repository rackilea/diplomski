public static <E> Tree<E> leaf(final E leaf) {
    return new Tree<E>() {
        @Override
        public <R> R accept(TreeVisitor<E, R> visitor) {
            return visitor.visit(leaf); //1 Ok in Java 8, fail in Java < 8
        }
    };
}