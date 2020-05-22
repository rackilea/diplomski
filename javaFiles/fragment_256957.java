@WebEndpoint(name = "WSHttpBinding_ICustomerService")
public ICustomerService getWSHttpBindingICustomerService() {
    WebServiceFeature wsAddressing = new AddressingFeature(true);

    ICustomerService service =
        super.getPort(new QName("http://xmlns.example.com/services/Customer",
                "WSHttpBinding_ICustomerService"), ICustomerService.class, 
                wsAddressing);

    Map<String, Object> context = ((BindingProvider)service).getRequestContext();

    Map<String, List<String>> headers = new HashMap<String, List<String>>();
    headers.put("Username", Collections.singletonList("yourusername"));
    headers.put("Password", Collections.singletonList("yourpassword"));

    return service;
}