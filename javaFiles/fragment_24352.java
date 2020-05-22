public List<T> flattenInOrder(final Tree<T> tree) {
    final EitherOr<T, Triple<Tree<T>>> EitherOr = tree.get();
    if (EitherOr.isLeft()) {
        return Collections.singletonList(EitherOr.ifLeft(this.ifLeftFunction));
    }

    return EitherOr.ifRight(this.ifRightFunction);
}