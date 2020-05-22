Session sess = factory.openSession();
Transaction tx = null;
try {
    tx = sess.beginTransaction();

    // your updates to the database
    create(A);
    create(B);


    tx.commit();
}
catch (RuntimeException e) {
    if (tx != null) tx.rollback();
    throw e; // or display error message
}
finally {
    sess.close();
}