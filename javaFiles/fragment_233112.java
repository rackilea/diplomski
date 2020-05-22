public void sendReports() throws IOException {
    ReportService service = new ReportService();
    QName portQName = new QName("http://URL/ReportService", "ReportService");
    req = readFile("C:/temp/myFile.xml", "UTF-8");;
    try {

        // Call Web Service Operation
        Dispatch<Source> sourceDispatch = null;
        sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);

        Map<String, Object> map = sourceDispatch.getRequestContext();
        map.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
        map.put(BindingProvider.SOAPACTION_URI_PROPERTY, "SendReports");

        Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }
}