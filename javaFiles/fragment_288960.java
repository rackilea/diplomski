MarshalBase64 mbase = new MarshalBase64();
SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
request.addProperty("howMany", howMany);
request.addProperty("airport", airport);
request.addProperty("filter", "");
request.addProperty("offset", 0);
SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.bodyOut = request;
envelope.encodingStyle = SoapSerializationEnvelope.ENC2003;
envelope.dotNet = true;
envelope.setOutputSoapObject(request);
String n = "";
HttpTransportSE ht = new HttpTransportSE(URL, 60000);
ht.debug = true;
try {
     mbase.register(envelope);
     ht.call(SOAP_ACTION, envelope);
     SoapObject response = (SoapObject) envelope.getResponse();
     } catch (Exception e) {
         e.printStackTrace();
     }