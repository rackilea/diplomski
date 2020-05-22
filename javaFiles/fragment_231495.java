@Test
public void testFooError(){
    String key = "test";
    String value = "expected";
    boolean exceptionThrown = false;
    daoClass daoMock = createMock(daoClass.class);
    try{
      expect(daoMock.lookup(key)).andReturn(value);
    }catch (DBException e) {
      exceptionThrown = true;
    }
    // assert exceptionThrown is true
    ...
}