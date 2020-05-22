@Named("employeeConverter")
public class EmployeeConverter implements Converter {

    @Inject
    private EmployeeService employeeService;

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")) {
            return null;
        }
        Employee employee = employeeService.getEmployeeByNumber(value);//or if it is not a String, replace value with Integer.parseInt(value)
        if(employee == null) {
            throw new ConverterException(new FacesMessage("Employee with number: " + value + " not found."));
        }
        return employee;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Employee) || (value == null)) {
            return null;
        }
        return ((Employee)value).getEmployeeNumber();
    }

}