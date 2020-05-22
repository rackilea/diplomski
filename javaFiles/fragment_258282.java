@ManagedBean
@SessionScoped
public class PropertyManagedBean {

    private PropertyJpaController controller;
    private List<Property> properties;

    public PropertyManagedBean() {
        controller = new PropertyJpaController();
        extractProperties();
    }

    public void propertyRowEdit(RowEditEvent event) {
        Property property = (Property) event.getObject();
        try {
            controller.update(property);
        } catch (Exception ex) {
            // TODO: Customize work with exceptions
        }
        extractProperties();
    }

    public List<Property> getProperties() {
        return properties;
    }

    private void extractProperties() {
        properties = controller.findPropertyEntities();
    }
}