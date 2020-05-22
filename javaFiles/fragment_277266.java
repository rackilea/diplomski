public Customer updateCustomer(Customer cust) {

       EntityManagerFactory emf = ... ;   EntityManager em =
     emf.createEntityManager();   try {
     EntityTransaction t = em.getTransaction();
     try {
       t.begin();  
       // business logic to update the customer
       em.merge(cust);
       t.commit();
     } finally {
       if (t.isActive()) t.rollback();
     }   } finally {
     em.close();
       }       
    }