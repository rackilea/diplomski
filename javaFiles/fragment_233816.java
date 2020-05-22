Transaction tx = session.beginTransaction() ;
  SqlWork sqlWork = new SQLWork(a,b,c) ; // used inside execute <br/>
  session.doWork(sqlWork) ;
  tx.commit();
} catch (HibernateException he) {
tx.rollback();
} finally {
session.close()
}