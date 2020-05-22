@Test
public void abTest () {
    FakeApplication app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
    Helpers.start(app);

    A a = new A();
    B b = new B();
    a.setId(1L);
    b.setId(2L);
    a.setB(b);
    b.setA(a);
    b.setName("bbb");

    Ebean.save(b);
    Ebean.save(a);

    A fa = Ebean.find(A.class, 1L);
    System.out.println("a.id: "+fa.getId());
    System.out.println("a.b.id: "+fa.getB());
    System.out.println("a.b.name: "+fa.getB().getName());

    A a1 = new A();
    a1.setId(3L);
    Ebean.save(a1);
    A fa1 = Ebean.find(A.class, 3L);
    System.out.println("a1.id: "+fa1.getId());
    System.out.println("a1.b.id: "+fa1.getB());

    B fb = Ebean.find(B.class, 2L);
    System.out.println("b.id: "+fb.getId());
    System.out.println("b.name: "+fb.getName());
    System.out.println("b.a.id: "+fb.getA().getId());
}