class A {}
class B extends A {}

B b = new B();
b instanceof A // true
b.getClass() == A.class // false