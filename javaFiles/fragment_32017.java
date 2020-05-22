@Test
public void testExceptionEntityExistInsertUser() throws Exception {
    System.out.println("entity already exist exception");
    boolean result;
    user.setData(null) // assuming data has a NotNull tag
    result = userDao.insertUser(user);
}