public static void main(String[] args) throws Exception
{
    String endPoint = "http://localhost:8080/StudentServiceImplService/StudentServiceImpl";

    ServiceClient sc = new ServiceClient();

    Options opts = new Options();
    opts.setTo(new EndpointReference("http://localhost:8080/StudentServiceImplService/StudentServiceImpl"));
    sc.setOptions(opts);

    OMFactory fac = OMAbstractFactory.getOMFactory();
    OMNamespace omNs = fac.createOMNamespace("http://services.tuto.java.com/","ns1");

    OMElement method = fac.createOMElement("getStudents", omNs);
    OMElement res = sc.sendReceive(method);
    System.out.println(res);

    Iterator<OMElement> it = res.getChildElements();
    while(it.hasNext())
    {
        System.out.println(it.next());
    }
}