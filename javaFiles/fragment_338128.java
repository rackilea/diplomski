@Transactional
 public TestServiceImple implements TestService {

     public void callDaoMethods(){
      fooDao.action1();
      barDao.action2();
     }

 }