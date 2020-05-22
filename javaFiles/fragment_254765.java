public class UIInputDateRangeValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) {
        UIInputDate inputDate = (UIInputDate) component;
        Date minDate = inputDate.getMinDate();
        Date maxDate = inputDate.getMaxDate();
        Date date = (Date) value;

        // ... Use Date#after(), Date#before(), etc.
    }

}