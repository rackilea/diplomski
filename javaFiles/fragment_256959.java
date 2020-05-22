@WebEndpoint(name = "WSHttpBinding_ICustomerService")
public ICustomerService getWSHttpBindingICustomerService() {
    WebServiceFeature wsAddressing = new AddressingFeature(true);

    ICustomerService service =
        super.getPort(new QName("http://xmlns.example.com/services/Customer",
                "WSHttpBinding_ICustomerService"), ICustomerService.class, 
                wsAddressing);

    Map<String, Object> context = ((BindingProvider)service).getRequestContext();

    context.put(BindingProvider.USERNAME_PROPERTY, "yourusername");
    context.put(BindingProvider.PASSWORD_PROPERTY, "yourpassword");

    return service;
}