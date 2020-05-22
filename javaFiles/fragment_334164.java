@Test
  public void simpleCrudTest() {
    U user = new U("name", new A("address"));

   //will work when this is added 
   a.setUser(user);
   uRepository.save(user);

  }