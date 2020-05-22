@Aspect
public class DtoValidator {

    private Validator validator;

    public DtoValidator() {
    }

    public DtoValidator(Validator validator) {
        this.validator = validator;
    }

    public void doValidation(JoinPoint jp){
        for( Object arg : jp.getArgs() ){
            if (arg != null) {
                Set<ConstraintViolation<Object>> violations = validator.validate(arg);
                if( violations.size() > 0 ){
                    throw buildError(violations);
                }
            }
        }
    }

    private static BadRequestException buildError( Set<ConstraintViolation<Object>> violations ){
        Map<String, String> errorMap = new HashMap<String, String>();
        for( ConstraintViolation error : violations ){
            errorMap.put(error.getPropertyPath().toString(), error.getMessage());
        }
        return new BadRequestException(errorMap);
    }
}