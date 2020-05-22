C c = mock(C.class);
c.doIt();

replay(c);

B b = new B();
b.setC(c);
A a = new A();
a.setB(b);

a.doSomething();

verify(c);