public void testCreateDummyRequest(){
    //create my mock holder
    Holder mockHolder = new Holder();

    MyClass mockObj = Mockito.spy(new MyClass());

    Mockito.doNothing().when(mockObj).doSomething();

    mockObj.createDummyRequest(mockHolder);
}