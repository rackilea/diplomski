private static String serviceUrl = "";

public static void setUrl(String url){
    serviceUrl = url;
}

public ServiceClient(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
}

public ServiceClient() {
    super(serviceUrl, new QName("http://tempuri.org/", "Service"));
}