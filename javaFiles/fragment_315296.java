private boolean isMTOM(SOAPMessage msg) throws SOAPException, IOException
{

    boolean isMTOM = false;

    MimeHeaders headers = msg.getMimeHeaders();
    String[] contentType = headers.getHeader("Content-Type");

    if(contentType[0].toLowerCase().contains("multipart/related") && (contentType[0].toLowerCase().contains("application/soap+xml") || contentType[0].toLowerCase().contains("application/xop+xml"))) {
        isMTOM = true;
    }

    return isMTOM;
}