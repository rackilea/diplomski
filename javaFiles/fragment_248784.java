public class CustomValidatorRegistry {

    private List<Validator> validatorList = new ArrayList<>();

    public void addValidator(Validator validator){
        validatorList.add(validator);
    }

    public List<Validator> getValidatorsForObject(Object o) {
        List<Validator> result = new ArrayList<>();
        for(Validator validator : validatorList){
            if(validator.supports(o.getClass())){
                result.add(validator);
            }
        }
        return result;
    }
}