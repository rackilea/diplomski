@Override
public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
    if (submittedValue == null || submittedValue.isEmpty()) {
        return null;
    }

    Employee employee = findEmployeeInDatabase(submittedValue);

    if (employee == null) {
        throw new ConverterException("Sorry, unknown employee.");
    }
    else {
        return employee;
    }
}