/*
* Vishal Mokal 05-MAR-2015
* soapCALL() function returns String Array.
* Make A sope call and returns response. 
* if responce is success full then user will get responce array 
* first element status = 1 if syccessfull 0 = if any exception of faliur 
* second element = response srtring if successful or error message.
* */
public String[] soapCALL(RequestDetails requestDetails, String wsdlUserName, String wsdlPassword , String headerName) {

    String url = requestDetails.getUrl().toString();
    String nameSpace = requestDetails.getNameSpace().toString();
    String methodName = requestDetails.getMethodName().toString();
    String soapAction = requestDetails.getSoapAction().toString();

    String[] responses = new String[2];

    Element[] header = new Element[1];

   // header[0] = new Element().createElement(nameSpace, "AuthenticationHeader");
    header[0] = new Element().createElement(nameSpace, headerName);

    try {
        Element UserName = new Element().createElement(nameSpace, "UserName");
        UserName.addChild(Node.TEXT, wsdlUserName);
        header[0].addChild(Node.ELEMENT, UserName);
        Element Password = new Element().createElement(nameSpace, "Password");
        Password.addChild(Node.TEXT, wsdlPassword);
        header[0].addChild(Node.ELEMENT, Password);
        SoapObject request = requestDetails.getSoapObject();

        SoapSerializationEnvelope soapSerilizationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerilizationEnvelope.dotNet = true;
        soapSerilizationEnvelope.headerOut = header;
        soapSerilizationEnvelope.setOutputSoapObject(request);
        Object env = soapSerilizationEnvelope.bodyOut;
        HttpTransportSE httptransport = new HttpTransportSE(url);
        httptransport.call(soapAction, soapSerilizationEnvelope);
        SoapPrimitive response = (SoapPrimitive) soapSerilizationEnvelope.getResponse();

        responses[0] = "1";
        responses[1] = response.toString();


        Log.d("Respons", response.toString());
        return responses;


    } 

    catch (SocketTimeoutException e)
    {
        responses[0] = "0";
        responses[1] = "Sorry!Unable To Connect Server Please Check Your Internet Connection Or Try After Some Time.";
        return responses;

    }
    catch (SocketException e)
    {
        responses[0] = "0";
        responses[1] = "Sorry!Unable To Connect Server Please Try After Some Time.";
        return responses;

    }        
    catch (Exception e) {
        responses[0] = "0";
        responses[1] = "Sorry!Unable To Connect Server Please Try After Some Time.";
        return responses;

    }  
}