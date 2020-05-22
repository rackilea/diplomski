private static B getB(){
   A a = new A();
   B b = a.getB();
   a = null; // not really required it will be gone as soon as I get out of this method.
   return b;
}


public void addToALookupMap(){
    B b = getB();
    aStaticFinalLookupMap.put(b.getId(), b); //b is not garbage collected until the map get, at least
}