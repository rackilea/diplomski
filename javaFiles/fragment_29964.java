Object o1 = new A();
Object o2 = new String();

void doSomething(Object o) {
    o.m(); // compilation error
}