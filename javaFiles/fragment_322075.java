A a = new A();

BId bid = new BId();
bid.setAtt("text"); // notice that the idA attribute is never manually set, since it is derived from A

B b = new B();
b.setId(bid);
b.setA(a);

a.getListB().add(b);

em.persist(a);
em.persist(b);