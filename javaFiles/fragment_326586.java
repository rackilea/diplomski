StatelessSession session = sessionFactory.openStatelessSession();
Transaction tx = session.beginTransaction();
for ( int i=0; i<100000; i++ ) {
    Item item = new Item(...);
    session.insert(item);
}
tx.commit();
session.close();