@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
    Person per = new Person();
    per.setName("Mulesoft");
    eventContext.getMuleContext().getRegistry().registerObject("personObject", per);
    return eventContext;
}