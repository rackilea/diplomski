public class MyValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return HashMap.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       // do your custom validation.
       // if you don't call error.reject* it is considered a valid argument
    }