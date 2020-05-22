EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.getTransaction().begin();
Session aNewSession = entityManager.unwrap( Session.class )
  .getFactory()
  .getCurrentSession();
// at this point entityManager is scoped to a transaction
// aNewSession is not scoped to any transaction
// this also likely uses 2 connections to the database which is a waste