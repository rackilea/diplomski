@WebEndpoint(name = "WSHttpBinding_ICustomerService")
public ICustomerService getWSHttpBindingICustomerService() {
    WebServiceFeature wsAddressing = new AddressingFeature(true);

    ICustomerService service =
        super.getPort(new QName("http://xmlns.example.com/services/Customer",
                "WSHttpBinding_ICustomerService"), ICustomerService.class, 
                wsAddressing);

    NtlmAuthenticator auth = new NtlmAuthenticator(username, password);  
    Authenticator.setDefault(auth);   

    return service;
}