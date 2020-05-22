@Entity
class Container {
     private Set<Item> itemsInternal;
     private ObservableSet<Item> items;
     private ObservableSet<Item> roItems;

     // ORM access by PROPERTY

     public Container() {
        // first time collection initialization 
         setItemsInternal(new LinkedHashSet<>());
     }

     @Transient
     public ObservableSet<Item> getItems() {return roItems;}

     // private methods for ORM   

     @OneToMany(mappendBy = "parent")
     // order the data when querying the DB 
     // and use LinkedHashSet as underlying collection
     @OrderBy("created") 
     private Set<Item> getItemsInternal() {
          return itemsInternal;
     }

     private void setItemsInternal(Set<Item> value) {
         itemsInternal = value;
         items = FXCollection.observableSet(itemsInternal);
         roItems = FXCollection.unmodifiableObservableSet(items);
     }
}