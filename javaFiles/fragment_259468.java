class PersonResultHandler implements ResultHandler {
    @Override
    public void handleResult(ResultContext context) { 
        Person person = (Person)context.getResultObject(); 
        // process person here
    }
};
PersonResultHandler handler = new PersonResultHandler();
PersonMapper personMapper = ...;
personMapper.selectAllPersons(handler);