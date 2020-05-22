Session session = SessionFactory.openSession();
Transaction tx = session.beginTransaction();
for ( int i=0; i<100000; i++ ) {
    Employee emp = new Employee(.....);
    session.save(emp);
}
tx.commit();
session.close();