private ArrayList<DataSetObserver> observers = new ArrayList<DataSetObserver>();

public void registerDataSetObserver(DataSetObserver observer) {
    observers.add(observer);
}
public void notifyDataSetChanged(){
    for (DataSetObserver observer: observers) {
        observer.onChanged();
    }
}