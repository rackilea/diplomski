public class UnmodifiableArrayList<E>  extends ArrayList<E> {

    public UnmodifiableArrayList(Collection<? extends E> c) {
        super(c);
    }

    public boolean add(int index) {
        return false;//Returning false as the element cannot be added 
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;//Returning false as the element cannot be added 
    }

    public E remove(int index) {
        return null;//Returning null as the element cannot be removed
    }
}