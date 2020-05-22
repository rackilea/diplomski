import org.ksoap2.*;
                    import org.ksoap2.serialization.SoapObject;
                    import org.ksoap2.serialization.SoapPrimitive;
                    import org.ksoap2.serialization.SoapSerializationEnvelope;
                    import org.ksoap2.transport.*;

                    public class soapclass 
                    {
                    private String[] resultValue;
                    private String res;
                    final String NAMESPACE = "http://tempuri.org/"; //the namespace that you'll find in the header of your asmx webservice
                    String METHOD_NAME= "HelloWorld"; //the webservice method that you want to call
                    String SOAP_ACTION = NAMESPACE+METHOD_NAME;
                    final String URL = "http://192.168.1.3/Myapp/WebService1.asmx"; //the url of your webservice
                    public soapclass()
                    {

                    this.SOAP_ACTION =NAMESPACE+METHOD_NAME;
                    }
                    public String callHello()
                    {
                    try {

                    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);
                    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                    androidHttpTransport.call(SOAP_ACTION, envelope);
                    SoapPrimitive response = (SoapPrimitive)envelope.getResponse(); //get the response from your webservice
                    res= response.toString();

                    }
                    catch (Exception e) {

                    res =e.getMessage();
                    }
                    return res;
                    }