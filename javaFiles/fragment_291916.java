Iterator<?> iter = ls.iterator();
while(iter.hasNext()) {
  iter.next();
  iter.remove();
  if(iter.hasNext()) {
    iter.next();
  }
}