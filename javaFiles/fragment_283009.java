A a = new A();
B b = new B();

a.setB(b);

/**
  * b property will be saved because Cascade.SAVE_UPDATE
  */
Serializable id = session.save(a);

b = (B) session
        .createQuery("from B b left join fetch b.a where b.id = :id")
        .setParameter("id", id)
        .list()
        .get(0);

Assert.assertEquals(b.getId(), b.getA().getId());