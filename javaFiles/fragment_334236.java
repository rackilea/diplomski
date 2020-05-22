try {
    EAXMLExchange.convertEAModelToEAXml("Hello", "World");
} catch (Exception e) {
    IStatus status = new Status(Status.ERROR,"EAXMLModelExchangeWizard","Error calling other plugin",e);
    Activator.getDefault().getLog().log(status);
}