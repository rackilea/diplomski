public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass==Person.class;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person)o;
        if(person.getAge()<=0){
            errors.rejectValue("age", "Age is too small");
        }
    }
}