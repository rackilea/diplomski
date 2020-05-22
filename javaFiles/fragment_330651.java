tx.begin();
Parent p = new Parent();
Child c = new Child(); 
c.setParent(p);
em.persist(c);
tx.commit();