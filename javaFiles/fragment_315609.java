class A<T extends A> {
  abstract T add();
  abstract T addWithParam(T t);
}
class B extends A<B> {
  B add() { ... }
  B addWithParam(B b) { ... }
}