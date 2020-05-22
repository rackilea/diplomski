public class LocalValidatorFactoryBeanMock extends LocalValidatorFactoryBean
{
    private boolean fakeErrors;

    public void fakeErrors ( )
    {
        this.fakeErrors = true;
    }

    @Override
    public boolean supports ( Class<?> clazz )
    {
        return true;
    }

    @Override
    public void validate ( Object target, Errors errors, Object... validationHints )
    {
        if (fakeErrors)
        {
            errors.reject("error");
        }
    }
}