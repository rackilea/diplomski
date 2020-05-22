class UserContact implements Validatable
{

    // some 
    // code
    // related to User Contact

    // 1 rule instance for the entire class, not a new one per call to 'validate'
    private static EMailValidationRule emailRule = new EmailValidationRule();
    private static PhoneValidationRule phoneRule = new PhoneValidationRule();

    public void validate() throws Exception
    {
        emailRule.applyRule("developer@stackoverflow.com");
        phoneRule.applyRule("+1234567890");
    }
}