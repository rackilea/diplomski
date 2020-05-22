// do some work
 ...

 tx.commit(); } catch (RuntimeException e) {
 if ( tx != null && tx.isActive() ) tx.rollback();
 throw e; // or display error message } finally {
 em.close(); }