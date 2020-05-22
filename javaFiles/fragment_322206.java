@FacesValidator("myCheckboxValidator")
public class MyCheckboxValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        UIInput chartTypeComponent = (UIInput) component.getAttributes().get("chartType");
        String chartType = (String) chartTypeComponent.getValue();
        List<String> selectedItemscheckbox = (List<String>) value;

        if ("PieChart".equals(chartType) && selectedItemscheckbox.size() > 1) {
            throw new ValidatorException(new FacesMessage("Max 1 item allowed"));
        }
        else if ("BarChart".equals(chartType) && selectedItemscheckbox.size() > 2) {
            throw new ValidatorException(new FacesMessage("Max 2 items allowed"));
        }
    }

}