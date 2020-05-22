@Autowired
BasicTransactionalService bean;

@Test
public void testTransactionIsolation() {
  bean.testFlushInTransactional();
}

@Test(expected = TransactionRequiredException.class)
@SuppressWarnings("deprecation")
public void testThrowsTransactionRequiredException() {
  bean.testFlushOutsideTransactional();
}

@Test
public void testTransactionalSubroutine(){
  bean.testFlushSubroutineTransactional();
}