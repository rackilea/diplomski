for (Iteratory<List<String> itr = lists.iteator(); itr.hasNext(); ) {
  List<String> elementList = itr.next();
  ...

  if( ... ) {
    itr.remove();
  }
}