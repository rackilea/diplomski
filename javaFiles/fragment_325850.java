public class UrlCollectionValidator implements ConstraintValidator<URLCollection, Collection<String>> {

    @Override
    public void initialize(URLCollectionconstraint) { }

    @Override
    public boolean isValid(Collection<String> urls, ConstraintValidatorContext context) {
        return // the validation logics
    }
}