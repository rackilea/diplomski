public class ServiceController{

    @Autowired
    @Qualifier("validatorFactoryBean")
    private LocalValidatorFactoryBean validatorFactoryBean;

    @PostMapping
    public Service create() {
        ... some additional code...
        return createServiceObject();
    }

    private Service createServiceObject(){
        Service service = new Service();
        service.setName(someInputFromForm)

        DataBinder binder = new DataBinder(service);
        binder.addValidators(validatorFactoryBean);
        binder.validate();
        BindingResult result = binder.getBindingResult();
        if(result.hasErrors()){
            // here you can throw exception or do something else
        }
        return service;
    }
}