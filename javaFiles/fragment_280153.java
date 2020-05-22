Session sess = sf.openSession();
Transaction tx;
try {
     tx = sess.beginTransaction();

     // Your query etc.         
     Query query = sess.createSQLQuery(hql2);
     //...

     tx.commit();
}
catch (Exception e) {
     if (tx != null) tx.rollback();
     throw e;
}
finally {
     sess.close();
}