http://www.example.org/NewWSDLFile --> Consider this as Your Name Space

@WebEndpoint(name = "MyServiceSOAP11port_http")
 public NewWSDLFile getNewWSDLFileSOAP1() {
    return super.getPort(new QName("http://www.example.org/NewWSDLFile/", 
   "MyServiceSOAP11port_http"), NewWSDLFile.class);
}