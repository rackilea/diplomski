private final A a;
private final B b;
private final C c = createCSomehow();

public Main(A a){
  this.a = a;
  this.b = null;
}

public Main(B b) {
  this.b = b;
  this.a = null;
}