public class Creator<A> {
    A a, b;

    public Creator(Class<A> childrenType) throws IllegalAccessException, InstantiationException {
        a = childrenType.newInstance();
        b = childrenType.newInstance();
    }
}