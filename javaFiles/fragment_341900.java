public void add(T t) {
   synchronized(items) {
      items.add(t);
   }
}

public void clear() {
   items.clear();
}