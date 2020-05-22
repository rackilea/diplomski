delete.setOnAction(e -> {
   Session session = sf.openSession();   
   Transaction tx;

   try{
     tx = session.beginTransaction();

       Query query = session.createQuery("from Employee where user = :user and password = :password");
     query.setString("user", username.getText());
     query.setString("password", password.getText());

     Employee userToDelete = (Employee)query.uniqueResult();  

     session.delete(userToDelete );                      
     tx.commit(); 
   }catch(Exception e){
       tx.rollback();
   }finally{
        session.close();
   }