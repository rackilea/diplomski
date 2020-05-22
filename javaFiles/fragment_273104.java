public class FlattenList<T> implements Iterable<T>{
    private List<List<T>> lists;
    public FlattenList(List<List<T>> list){
        this.lists = list;
    }
    public Iterator<T> iterator(){
        return new ListIterator();
    }
    class ListIterator implements Iterator<T>{
        private Iterator<List<T>> listsiterator;
        private Iterator<T> listiterator;
        public ListIterator(){
            if (lists != null) {
                listsiterator = lists.iterator(); // The conversion mismatch here
            }
        }
        //..
    }
}