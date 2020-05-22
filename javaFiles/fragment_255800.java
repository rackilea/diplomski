@Override
public void handleFault(SoapMessage message) {
    // Every exception will be wrapped into a Fault object by CXF
    Fault f = (Fault) message.getContent(Exception.class);
    // You should inspect its g.getCause() to maybe identify what went wrong
    // A CXF Fault also much ressembles a SOAPFault element
    f.setMessage("Your SOAP Fault message");
    // You can access the DOM detail of the fault
    Element detail = f.getOrCreateDetail();
    Element newDetailEntry = detail.getOwnerDocument().createElementNS("detailNs", "detailName");
    newDetailEntry.setTextContent("Content for your soap fault detail");
    detail.appendChild(newDetailEntry);
    // And so on. f.setFaultCode(qName);...
}