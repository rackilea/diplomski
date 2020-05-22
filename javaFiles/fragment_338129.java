public TestServiceImple implements TestService {

 @Transactional
 public void callDaoMethods(){
   fooDao.action1();
   barDao.action2();
 }
}