public class MyFlattenTree<T> {

    private final Function<Triple<Tree<T>>, List<T>> ifRightFunction = new Function<Triple<Tree<T>>, List<T>>() {

        @Override
        public List<T> apply(final Triple<Tree<T>> t) {
            final List<T> res = new ArrayList<>();
            res.addAll(MyFlattenTree.this.flattenInOrder(t.left()));
            res.addAll(MyFlattenTree.this.flattenInOrder(t.middle()));
            res.addAll(MyFlattenTree.this.flattenInOrder(t.right()));
            return res;
        }
    };

    private final Function<T, T> ifLeftFunction = new Function<T, T>() {

        @Override
        public T apply(final T t) {
            return t;
        }
    };

    public static void main(final String[] args) {
        final Tree<String> tree = new Node<>(new Leaf<>("1"), new Node<>(new Leaf<>("5"), new Leaf<>("4"), new Leaf<>("9")), new Leaf<>("6"));
        System.out.println(new MyFlattenTree<String>().flattenInOrder(tree));
    }

    public List<T> flattenInOrder(final Tree<T> tree) {
        final EitherOr<T, Triple<Tree<T>>> EitherOr = tree.get();
        if (EitherOr.isLeft()) {
            return Collections.singletonList(EitherOr.ifLeft(this.ifLeftFunction));
        }

        return EitherOr.ifRight(this.ifRightFunction);
    }
}