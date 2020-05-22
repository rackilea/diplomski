public class SimpleFinder<T extends Item> implements Finder<Stack<T>, T> {

    @Override
    public Stack<T> find(Stack<T> s, int a) {
        Stack<T> stack = s.getCopy();
        return stack;
    }

}