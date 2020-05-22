ServiceCaller {
    private final ServiceFactory serviceFactory;
    private Service service;

    @Inject
    public ServiceCaller(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public void initialize(List<String> params) {
        service = serviceFactory.create(params.get(0), params.get(1));
    }
}

class Service {
    private final SomeClass classe;

    public Service(SomeClass classe, String param1, String param2) {
        //call methods to do stuffs with params
        this.classe = classe;
    }
}

class ServiceFactory {
    private final SomeClass classe;

    @Inject
    public ServiceFactory(SomeClass classe) {
        this.classe = classe;
    }

    public Service create(String param1, String param2) {
        return new Service(classe, param1, param2);
    }
}