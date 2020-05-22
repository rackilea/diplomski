final String METHOD_NAME = "ServiceName"; // our
    final String SOAP_ACTION = "http://tempuri.org/ServiceName";
    String result = null;

    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    request.addProperty("IMEI", Imei);
    request.addProperty("asscd", asscd);

    SoapPrimitive response = null;

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                                                    SoapEnvelope.VER11);
                    envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);
                    try {

                                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                                    androidHttpTransport.call(SOAP_ACTION, envelope);

                                    response = (SoapPrimitive) envelope.getResponse();
                                                 //here SoapPrimitive is an important part
                                    result = response.toString();

                    } catch (Exception e) {
                                    e.printStackTrace();
                    }


        return result;