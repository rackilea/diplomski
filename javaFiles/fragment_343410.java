em.getTransaction().begin();
MyEntity e = new MyEntity();
...
em.persist(e);
em.flush();
e.setBId(e.getAId());
em.merge(e);
...
em.getTransaction().commit();