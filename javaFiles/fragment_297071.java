session = hu.getSessionFactory().openSession();
Transaction transaction = session.beginTransaction();   // add this line
Query q= session.createQuery("update MessageQueue set   returnStatus=:returnStatus where id=:msg_id");
System.out.println("QQQQQQQQQQQQQQQQQQQQQQUERY ");
q.setParameter("msg_id", id);
System.out.println("1111111111111111111111111111 param "+id);
q.setParameter("returnStatus", returnStatus);
System.out.println("222222222222222222222 param "+returnStatus);
System.out.println(q.getQueryString());
int res=q.executeUpdate();
transaction.commit();                                   // add this line too
session.close();