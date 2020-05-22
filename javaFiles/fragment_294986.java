@Autowired
private SpringDataFooDAO fooDao;

public void testMethod() {
    try {
        Foo foo = fooDao.findOne(2L);
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        foo.setName("should be rolled back");
        new ExceptionThrower().doSomething("default string");
    } catch(Exception e) {
        updateSomeProperty(1L, "Changed name");
        throw new RuntimeException(e);
    }
}

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
private void updateSomeProperty(long id, String newFooName) {

    System.out.println("   ---   ");
    System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
    System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

     // Update property of test object.
     Foo foo = fooDao.findOne(id);
     foo.setName(newFooName);    
}