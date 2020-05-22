public static Session getSession() throws HibernateException {         
   Session sess = null;       
   try {         
       sess = sessionFactory.getCurrentSession();  
   } catch (org.hibernate.HibernateException he) {  
       sess = sessionFactory.openSession();     
   }             
   return sess;
}