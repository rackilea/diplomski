interface S extends Comparable<S> {}
class A implements S {
    @Override
    public int compareTo(final @NotNull S o) {
        return 0;
    }
}
class B implements S {
    @Override
    public int compareTo(final @NotNull S o) {
        return 0;
    }
}