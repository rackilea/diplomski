public class MyArrayList<E> extends ArrayList<E> {

    public E getLastItem(){
        return get(size()-1);
    }

}