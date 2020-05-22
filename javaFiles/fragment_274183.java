@Autowired
private UserDAO userDao;
public void doSomething(int someThingId) {
userDAO.findById(someThingId);
...
}