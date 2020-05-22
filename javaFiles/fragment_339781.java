Service service = EasyMock.createMock(Service.class);

// andAnswer style
service.call(anyObject(Service.AnotherClass.class));
expectLastCall().andAnswer(new IAnswer<Object>() {
    public Object answer() throws Throwable {
        Service.AnotherClass arg = (Service.AnotherClass) EasyMock.getCurrentArguments()[0];
        arg.setSuccessful(true); // or false in another test
        return null;
    }
});