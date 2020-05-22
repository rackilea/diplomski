@Aspect
@Component
public class CustomValidatingAspect {

    @Autowired
    private CustomValidatorRegistry registry; //aspect will use our validator registry


    @Before(value = "execution(public * *(..)) && annotation(com.mydomain.validation.CustomValidation)")
    public void doBefore(JoinPoint point){
        Annotation[][] paramAnnotations  =
                ((MethodSignature)point.getSignature()).getMethod().getParameterAnnotations();
        for(int i=0; i<paramAnnotations.length; i++){
            for(Annotation annotation : paramAnnotations[i]){
                //checking for standard org.springframework.validation.annotation.Validated
                if(annotation.annotationType() == Validated.class){
                    Object arg = point.getArgs()[i];
                    if(arg==null) continue;
                    validate(arg);
                }
            }
        }
    }

    private void validate(Object arg) {
        List<Validator> validatorList = registry.getValidatorsForObject(arg);
        for(Validator validator : validatorList){
            BindingResult errors = new BeanPropertyBindingResult(arg, arg.getClass().getSimpleName());
            validator.validate(arg, errors);
            if(errors.hasErrors()){
                throw new CustomValidatorException(errors);
            }
        }
    }
}