public class TempContainer<T> {
    private List<T> items; 
    public void setItems(List<T> items) {
       this.items = items;
    }

    public List<T> getItems() {
         return items;
    }
}