@Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        String propertyDir = eventContext.getMessage().getOutboundProperty("messageJSON");
        System.out.println(propertyDir);
        return null;
    }