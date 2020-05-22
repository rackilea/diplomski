if (!pSet.contains(x)) {
  synchronized (pSet) { 
  // Here you are sure to have the updated value of pSet    
  if (!pSet.contains(x)) {
    // do some exclusive work with x.
    pSet.add(x);
  }
}