public class APIHandler {

    @Autowired
    private Map<String, SomeInterface> impls;

    public ResponseEntity post(@RequestBody HandlingClass requestBody) {
        String beanName = "..."; // resolve from your requestBody        
        SomeInterface someInterface = impls.get(beanName);
        someInterface.doSomething();
    }
}