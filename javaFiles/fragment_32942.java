SoapObject soapObject = envelope.getResponse();
for (int i = 0; i < soapObject.getPropertyCount(); i++) {
        SoapObject resource = (SoapObject) response.getProperty(i);
        String uri = resource.getAttribute("uri").toString();
        String mimeType = resource.getAttribute("mimeType").toString();
        String size = resource.getAttribute("size").toString();
        String localURI = resource.getAttribute("localURI").toString();
        //do stuff
}