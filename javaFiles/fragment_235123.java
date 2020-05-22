C c = mock(C.class);
c.doIt();

replay(c);

B b = new B(c);
A a = new A(b);

a.doSomething();

verify(c);