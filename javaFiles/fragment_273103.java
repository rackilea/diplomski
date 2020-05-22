public class FlattenList<T> implements Iterable<T>{
    private List<List<T>> lists;
    public FlattenList(List<List<T>> list){
        this.lists = list;
    }
    public Iterator<T> iterator(){
        return new ListIterator();
    }
    class ListIterator<E> implements Iterator<E>{
        private Iterator<List<E>> listsiterator;
        private Iterator<E> listiterator;
        public ListIterator(){
            if (lists != null) {
                listsiterator = lists.iterator(); // The conversion mismatch here
            }
        }
        //..
    }
}