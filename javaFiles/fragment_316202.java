....
@PersistenceContext
EntityManager entityManager;
...
@Test
public void setActiveTest(){
  ...

  // clear the cache and force crudUser.findById from database
  entityManager.clear();

  Optional<User> optUser = crudUser.findById(user.getId());
  ...
}