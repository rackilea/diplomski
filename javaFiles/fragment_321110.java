for(A a : aList) {
    if(a instanceof B) {
        B b = new B(a.getX());
        aClones.add(b);
    }
    if(a instanceof C) {
        C c = new C(a.getX());
        aClones.add(c);
    }
}