@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
    Person person = eventContext.getMuleContext().getRegistry().lookupObject("personObject");
    System.out.println("Name is :"+person.getName());   
    return null;
}