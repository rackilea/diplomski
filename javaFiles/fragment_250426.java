public class ValidatorFactory{
    public static Validator getValidator(ValidatorType type){
        if(ValidatorType.AGE.equals(type)){
            return new AgeValidator(); //won't post the AgeValidator definition here
        }
        if(ValidatorType.LAST_NAME.equals(type)){
            return new LastNameValidator(); //won't post the LastNameValidator definition here
        }
        return null;
    }
}