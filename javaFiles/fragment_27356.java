public void test() {
    DomainInterface mock = EasyMock.create("mock", DomainInterface.class);

    // Expect that the subject will call setAnswer with an argument of "VALID"
    mock.setAnswer("VALID");

    EasyMock.replay();

    Subject subject = new Subject();
    subject.setDomainInterface(mock);

    DomainInterface domain = subject.process();    
    assertEquals("Not the same instance", mock, domain);

    // No need to assert the result of calling getAnswer - we've already asserted
    // that setAnswer will be called.
}