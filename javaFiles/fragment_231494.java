@Test
public void testFooNormal() throws DBException{
    String key = "test";
    String value = "expected";
    daoClass daoMock = createMock(daoClass.class);
    expect(daoMock.lookup(key)).andReturn(value);
    // do an assert on returned value
    ...
}