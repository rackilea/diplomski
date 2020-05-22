public class CustomFormTypes extends FormTypes {

    public CustomFormTypes() {
        // register Activiti's default form types
        addFormType(new StringFormType());
        addFormType(new LongFormType());
        addFormType(new DateFormType("dd/MM/yyyy"));
        addFormType(new BooleanFormType());
        addFormType(new DoubleFormType());
    }

    @Override
    public AbstractFormType parseFormPropertyType(FormProperty formProperty) {
        if (ImpactedSitesFormType.TYPE_NAME.equals(formProperty.getType())) {
            Map<String, String> values = new LinkedHashMap<>();
            for (FormValue formValue : formProperty.getFormValues()) {
                values.put(formValue.getId(), formValue.getName());
            }
            return new ImpactedSitesFormType(values);
        } else {
            // delegate construction of all other types
            return super.parseFormPropertyType(formProperty);
        }
    }

}