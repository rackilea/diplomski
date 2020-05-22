public class DesignSerializer extends JsonSerializer<Design> {

    @Autowired
        IDesignService designService;
    }

    public DesignSerializer(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);    
    }

...

}