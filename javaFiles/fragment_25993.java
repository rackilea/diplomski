import java.util.ArrayList;
import java.util.List;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;


public class ObservableCombindedList<E>  extends ModifiableObservableListBase<E> {
    private List<E> mainList = new ArrayList<E>();
    private List<ObservableList<E>> subLists = new ArrayList<>();
    private List<SubListListener> listeners = new ArrayList<>();


    private class SubListListener implements ListChangeListener<E>{

        public SubListListener (){
        }

        @Override
        public  void onChanged(ListChangeListener.Change<? extends E> c) {

            ObservableList<E> subList = (ObservableList<E>) c.getList();

            int subListPos = ObservableCombindedList.this.subLists.indexOf(subList);
            int idxstart = getStartIndex(subListPos);


            while (c.next()) {
                 if (c.wasPermutated() || c.wasUpdated()) {
                     for (int i = c.getFrom(); i < c.getTo(); ++i) {
                             ObservableCombindedList.this.set(i+idxstart,(E) subList.get(i));
                         }
                     }
                 if (c.wasRemoved()) {
                     ObservableCombindedList.this.remove(c.getFrom(),c.getTo());
                  }

                 if (c.wasAdded()){
                         for (int i = c.getFrom(); i < c.getTo(); ++i) {
                             ObservableCombindedList.this.add(i+idxstart,(E) subList.get(i));
                         }
                     }

                 };
        } //  void onChanged

    }  // private class SubListListener implements ListChangeListener<E>

    public  int getStartIndex(int listNr)
    {
        int index = 0;
        for (int i_list  = 0; i_list < listNr ; ++i_list)
        {
            index += this.subLists.get(i_list).size();
        }
        return index;
    }

    public void addSublist(ObservableList<E> list){
        SubListListener listener = new SubListListener();
        this.subLists.add(list);
        list.addListener(listener);

        this.listeners.add(listener);


        for (E el : list)
        {
            this.add(el);
        }
    } // public void addSublist

    public void removeSublist(int i){

        int i_start = getStartIndex(i);

        this.remove(i_start, i_start + this.subLists.get(i).size());

        ObservableList<E> sublist = this.subLists.remove(i);
        ObservableCombindedList<E>.SubListListener listener = this.listeners.remove(i);
        sublist.removeListener(listener);

    }

    @Override
       public E get(int index) {
           return this.mainList.get(index);
       }

    @Override
       public int size() {
           return this.mainList.size();
       }

    @Override
    protected void doAdd(int index, E element) {
        this.mainList.add(index, element);
       }

    @Override
    protected E doSet(int index, E element) {

       return this.mainList.set(index, element);
       }

    @Override
    protected E doRemove(int index) {
          return this.mainList.remove(index);
    }

}