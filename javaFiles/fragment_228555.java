Role r=new Role();
  r.setName("ROLE_NAME");

  user.setRole(r);
  r.setUser(user);
  session.saveOrUpdate(user);
  session.saveOrUpdate(r);