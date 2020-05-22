return new Map<String, B>() {
  // implement all methods that add or remove elements in map with something like this
  public B put(String name, B b) {
    // check consistency
    if(!b.getC().getName().equals(name)) { 
      // this sould be handled as an error
    }
    B oldB = get(name);
    mapB(b);
    return oldB;
  }

  // implement all accessor methods like this
  public B get(String name) {
    return bsMappedByCName.get(name);
  }

  // and so on...
};