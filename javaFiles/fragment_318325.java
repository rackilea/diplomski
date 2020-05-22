static {
    URL url = null;
    try {
        URL baseUrl;
        baseUrl = demo.ws.service.MaintainAddress_Service.class.getResource(".");
        url = new URL(baseUrl, "wsdl/MaintainAddress.wsdl");
    } catch (MalformedURLException e) {
        logger.warning("Failed to create URL for the wsdl Location: 'wsdl/MaintainAddress.wsdl', retrying as a local file");
        logger.warning(e.getMessage());
    }
    MAINTAINADDRESS_WSDL_LOCATION = url;
}