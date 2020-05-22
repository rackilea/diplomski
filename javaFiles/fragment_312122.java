String ticket;

    public void getSoap() {

    SoapObject request = new SoapObject(NAMESPACE, METHODNAME);
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.dotNet = true;
    envelope.implicitTypes = false;
    envelope.setOutputSoapObject(request);
    HttpTransportSE httpTransportSe = new HttpTransportSE(URL);
    httpTransportSe.debug = true;
    SoapObject response = null;

    try {
        httpTransportSe.call(SOAPACTION, envelope);
        response = (SoapObject) envelope.getResponse();
        ticket = response.getProperty("ticket").toString();

    } catch (Exception e) {
        e.printStackTrace();
    }

}