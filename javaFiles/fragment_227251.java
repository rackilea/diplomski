// a transient field to cache the map
private transient Map<String, B> bsMappedByCName;

public Map<String, B> getBsMappedByCName() {
  if(bsMappedByCName == null) {
    bsMappedByCName = new HashMap<String, B>();
    for(B b : bs) {
      mapB(b);
    }
  }
  // return as unmodifiable map so that it is immutable for clients
  return Collections.unmodifiableMap(bsMappedByCName);
}

private void mapB(B b) {
  // we assume here that field c in class B and likely also field name in class C are not nullable. Further more both of this fields sould be immutable (i.e. have no setter).
  if(bsMappedByCName.put(b.getC().getName(), b) != null) {
    // multiple bs with same CName, this is an inconsistency you may handle 
  }      
}