public class Baseclass<E extends Enum<E>> {

    private final E e;

    public Baseclass(E e) {
        this.e = e;
    }
}