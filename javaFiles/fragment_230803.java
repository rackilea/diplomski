public ObservableCollection implements Collection {

   private int sizetrigger;
   private Collection collection;
   private Collection<Listener> listeners = new ArrayList<Listener>();
   public ObservableCollection(Collection collection) {
     this.collection = collection;
   }

   @Override
   boolean add(Object element) {
     collection.add(element);
     if (size >= sizeTrigger) {
        fireSizeEvent();
     }
   }

   private fireSizeEvent() {
      for(Listener listener:listeners) {
         listener.thresholdReached(this);
      }
   }

   // addListener, removeListener and implementations of interface methods
}