public class RequestDetails {

private String nameSpace;
private String url;
private String methodName;
private String SoapAction;
private SoapObject soapObject;

public RequestDetails(String nameSpace, String url, String methodName, String soapAction) {
    this.nameSpace = nameSpace;
    this.url = url;
    this.methodName = methodName;
    SoapAction = soapAction;
}

public String getNameSpace() {
    return nameSpace;
}

public String getUrl() {
    return url;
}

public String getMethodName() {
    return methodName;
}

public String getSoapAction() {
    return SoapAction;
}


public SoapObject getSoapObject() {
    return soapObject;
}

public void setSoapObject(SoapObject soapObject) {
    this.soapObject = soapObject;
}