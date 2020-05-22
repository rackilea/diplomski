public class SimpleFinder<S extends Stack<T>, T extends Item> implements Finder<S, T> {

    @Override
    public S find(S s, int a) {
        Stack<T> stack = s.getCopy();
        return (S) stack;
    }

}