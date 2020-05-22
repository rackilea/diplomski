@Before   
public void setUp(){
    //set up, before every test method
}

@Transactional
@Test
public void test(){
}

@Rollback
@After
public void tearDown(){
   //tear down after every test method
}