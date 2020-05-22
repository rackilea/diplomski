List<A> list = new ArrayList<A>();

Iterator<A> iterator = list.iterator();
while (iterator.hasNext()) {
   A current = iterator.next();   

   if(current.isProperty()) {
   iterator.remove();;
  }
}