save.setOnAction(e -> {
   m.setUser(username.getText());
   m.setPassword(password.getText());   

   Session session = sf.openSession();   
   session.beginTransaction();                                                                                       
   session.save(m);                      
   session.getTransaction().commit();