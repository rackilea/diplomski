public class CommonWebBindingInitializer implements WebBindingInitializer {

    @Autowired
    private Validator validator;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.setValidator(validator);
        binder.setConversionService(conversionService);
    }

}