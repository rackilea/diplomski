public void add(E e) {
   System.out.println("add item " + e);
   super.add(e);
}

public void addAll(Collection<? extends E> c) {
   for (E e : c) {
       System.out.println("add item " + e);
   }
   super.addAll(c);
}