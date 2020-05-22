Session session = null;  
Transaction tx = null;  

try {  
session = sessionFactory.openSession();  
tx = session.beginTransaction();  
//YOUR CODE HERE 

tx.commit();  

}catch (Exception ex) {  
ex.printStackTrace();  
tx.rollback();  
}  
finally {session.close();}