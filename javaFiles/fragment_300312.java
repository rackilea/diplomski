class RegularImmutableList<E> extends ImmutableList<E> {

    final transient Object[] array;
      ^

    RegularImmutableList(Object[] array) {
        this.array = array;
    }
}