//Whenever you call getStuff() an empty list should be returned
EasyMock.expect(blah.getStuff()).andStubAnswer(new IAnswer<List<String>>() {
        @Override
        public List<Object> answer() throws Throwable {
            return new ArrayList<String>();
        }
    }