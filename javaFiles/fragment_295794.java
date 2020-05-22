public interface DumbTestInterface<E> {

    <T extends E> boolean addAll1(Collection<T> c);

    boolean addAll2(Collection<? extends E> c);

}