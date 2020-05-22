public static String WCFShow (String METHOD_NAME, int timeOut, List<KSoapParameters> parameters)  {

    SoapObject request = new SoapObject(Constant.NAMESPACE, METHOD_NAME);
    for (int i =0;i<parameters.size();i++){
        request.addProperty(parameters.get(i).getKey(),parameters.get(i).getValue());
    }
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.dotNet = true;
    List<HeaderProperty> header = new ArrayList<HeaderProperty>();
    header.add(new HeaderProperty("Authorization","Basic "+org.kobjects.base64.Base64.encode("admin:adminpass".getBytes())));
    envelope.setOutputSoapObject(request);

    Element headers[] = new Element[1];
    headers[0]= new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
    headers[0].setAttribute(envelope.env, "mustUnderstand", "1");
    Element security=headers[0];

    Element token = new Element().createElement(security.getNamespace(), "UsernameToken");
    token.setAttribute("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id", "UsernameToken-2");

    Element username = new Element().createElement(security.getNamespace(), "Username");
    username.addChild(Node.TEXT, "admin");
    token.addChild(Node.ELEMENT,username);

    Element password = new Element().createElement(security.getNamespace(), "Password");
    password.setAttribute(null, "Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
    password.addChild(Node.TEXT, "adminpass");
    token.addChild(Node.ELEMENT,password);

    headers[0].addChild(Node.ELEMENT, token);

    envelope.headerOut = headers;

    HttpTransportSE aht = new HttpTransportSE(Constant.URL,timeOut);
    aht.debug = true;

    try {
        aht.call(Constant.SOAP_ACTION+METHOD_NAME, envelope, header);
        //Log.d("AAAAASSSSSSDDDDD", envelope.getResponse().toString());
//            Object result = envelope.getResponse();
        Object result = envelope.bodyIn;

        resultData = result.toString();
        //Log.d("ERDINC", resultData.toString());
    } catch (IOException e) {
        e.printStackTrace();
        resultData="ERROR"+e.toString();
    } catch (XmlPullParserException e) {
        e.printStackTrace();
        resultData="ERROR"+e.toString();
    }

    return resultData;
}