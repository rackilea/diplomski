Transaction trx = null;  
  Session session = HibernateSessionFactory.getSession();  
  try {  
   trx = session.beginTransaction();  

   org.hibernate.Query query = session.getNamedQuery("SampleNameQuery");  
   query.setParameter(0,"fsdfsdf");         
   String value = "";  
   query.setParameter(1,value);         
   List objList = query.list();      
   trx.commit();