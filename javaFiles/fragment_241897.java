public class ValidateXimpl implements ConstraintValidator<ValidateX, String> {

@Autowired
DBRepo dbRepo;

@Override
public void initialize(ValidateX annotation) {
}

@Override
public boolean isValid(String value, ConstraintValidatorContext ctx) {
    try {
        XEntity X = dbRepo.findByEnum(value); // I want this entity in my controller
        RequestContextHolder.getRequestAttributes().setAttribute(
                "XEntity", X, RequestAttributes.SCOPE_REQUEST
        ); // I saved it in RequestContextHolder
        return (!value.isEmpty() && X != null);
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
}