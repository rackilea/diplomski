public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        FieldGroup fieldGroup = new BeanFieldGroup<Person>(Person.class);
        fieldGroup.setItemDataSource(new BeanItem<Person>(new Person(1L, "John", "Doe")));
        for (Object propertyId : fieldGroup.getUnboundPropertyIds()) {
            Field<?> field = fieldGroup.buildAndBind(propertyId);
            if ("id".equals(propertyId)) {
                field.setReadOnly(true);
            }
            layout.addComponent(field);
        }
        setContent(layout);
    }

}