final Function<Triple<Tree<T>>, List<T>> ifRightFunction = new Function<Triple<Tree<T>>, List<T>>() {

    @Override
    public List<T> apply(final Triple<Tree<T>> t) {
        final List<T> res = new ArrayList<>();
        res.addAll(MyFlattenTree.this.flattenInOrder(t.left()));
        res.addAll(MyFlattenTree.this.flattenInOrder(t.middle()));
        res.addAll(MyFlattenTree.this.flattenInOrder(t.right()));
        return res;
    }
};