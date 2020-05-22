expect(processor.process(arg1, list));
expectLastCall().anyTimes().andAnswer(new IAnswer<Object>() {
    public Object answer() throws Throwable {
        List myList = (List) EasyMock.getCurrentArguments()[1];
        // do your assertions on the list here (or change the order as required)
    }    
});