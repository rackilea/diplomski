public String saveId(String name){
  Session s= dao.getCurrentSession();
  try {
    return (String) s.save(new MyObject(name));
  } catch (PersistenceException pe) {
    return s.createQuery("SELECT x FROM MyObject X where x.name=:name").setParameter("name", name).getSingleResult().getId(); 
  }
}