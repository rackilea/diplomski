public class MyCustomObjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MyCustomObj.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MyCustomObj c = (MyCustomObj) target;
        Date startDate = c.getStartDate();
        Date endDate = c.getEndDate();
        if (startDate == null) {
            errors.rejectValue("startDate", "validation.required");
        }
        if (endDate == null) {
            errors.rejectValue("endDate", "validation.required");
        }
        if(startDate != null && endDate != null && endDate.before(startDate)){
            errors.rejectValue("endDate", "validation.notbefore.startdate");
        }
    }

}