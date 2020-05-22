A a = new A();
B b = new B();

/**
  * Set up both sides
  * Or use some kind of add convenience method
  */ 
a.setB(b);
b.setA(a);

/**
  * b property will be saved because Cascade.SAVE_UPDATE
  */
Serializable id = session.save(a);

b = (B) session
        .createQuery("from B b left join fetch b.a where b.id = :id")
        .setParameter("id", id)
        .list()
        .get(0);