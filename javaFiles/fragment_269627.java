final Iterator<Something> listIter = arrayList.iterator();
while(listIter.hasNext()) {
  final Something thing = listIter.next();
  if(someTest) {
    listIter.remove();
  }
}