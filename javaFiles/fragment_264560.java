@Autowired
UserDAO userDAO;

@Test
public void getUser_retrieves_users_added_by_addUser(){
    User addedUser = userDAO.add(new User("foo", "bar"));
    // ... flush data in the database and clear first cache level to avoid cache using
    User expectedUser =  userDAO.get(addedUser.getId());
   // assert the expected User
}

@Before
public void tearDown(){
   // clear data in the database
}