@After
public void clean(){
    // this method will be run after each single @Test method
    // you can use this to clean all resoruces after a test. in your case for example
    accountDao.deleteById(newAccount.getId());
}