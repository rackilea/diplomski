String URL = "http://xxx.xxx.com/xxx/xxx.asmx";
String METHOD_NAME = yourMethodName;
String NAMESPACE = "http://tempuri.org/";
String SOAP_ACTION = NAMESPACE+METHOD_NAME;
SoapObject resultRequestSOAP = null;
HttpConnection httpConn = null;
HttpTransport httpt;
SoapPrimitive response = null;
SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
request.addProperty("username", user_id);
request.addProperty("password", password);
System.out.println("The request is=======" + request.toString());
SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
envelope.dotNet = true;
envelope.setOutputSoapObject(request);
httpt = new HttpTransport(URL+C0NNECTION_EXTENSION);
httpt.debug = true;
try
{
    httpt.call(SOAP_ACTION, envelope);
    response = (SoapPrimitive) envelope.getResponse();
    String result =  response.toString();
    resultRequestSOAP = (SoapObject) envelope.bodyIn;
}
catch (IOException e) 
{
    System.out.println("The exception is IO==" + e.getMessage());
} 
catch (XmlPullParserException e) 
{
    System.out.println("The exception xml parser example==="
    + e.getMessage());
}
System.out.println( resultRequestSOAP);
return response + "";