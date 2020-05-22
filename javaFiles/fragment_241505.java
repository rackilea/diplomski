@Bean(name = "asdServiceGateway")
    public ASD asdServiceGateway() {
        ASDServiceV2 asdServiceV2=new ASDServiceV2();
        ASD client = new ASDServiceV2().getASDPortV2();
        BindingProvider provider = (BindingProvider) client;;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, userName);
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
        return client;
    }