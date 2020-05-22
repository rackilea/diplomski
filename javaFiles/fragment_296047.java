Session session = getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
MyEntity u = (MyEntity) session.get(MyEntity.class, id);
session.lock(u, LockMode.FORCE);
tx.commit();
session.close();