void printList(Collection myList) {
   for(Object o : myList) {
      if (Collection.class.isAssignableFrom(o.getClass())) {
          printList((Collection)o);
      }
      else {
          print o;
      }
  }
}