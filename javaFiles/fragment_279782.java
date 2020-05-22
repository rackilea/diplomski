public class ObservableList implements List<T> {
  private List<Listener> listeners = new ArrayList<Listener>();
  // usual methods for adding/removing listeners

  private List<T> list;
  public ObservableList(List<T> list) {
    this.list = list;
  }

  // implement methods from List and delegate to the internal list
  // send notifications to listeners for add/remove operations

  public boolean add(T item) {
    fireEvent(Type.ADD, item);  // like that
    return list.add(item);      // delegate to the internal list
  }
}