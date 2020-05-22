Session sess = factory.openSession();
 Transaction tx;
 try {
     tx = sess.beginTransaction();
     sess.update(someobject);
     tx.commit();
 }
 catch (Exception e) {
     if (tx!=null)
     tx.rollback();
     throw e;
 }
 finally {
     sess.close();
 }