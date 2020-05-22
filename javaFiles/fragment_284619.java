Account account1 = entityManager.createQuery(
    "select a from Account a where a.id = :id", 
    Account.class)
    .setParameter( "id", 1L )
.getSingleResult();
assertNotNull( account1 );
try {
    Account account2 = entityManager.createQuery(
        "select a from Account a where a.id = :id", 
        Account.class)
    .setParameter( "id", 2L )
    .getSingleResult();
}
catch (NoResultException expected) {
    expected.fillInStackTrace();
}