public class PropertyJpaController {

    private List<Property> properties = new ArrayList<Property>();

    {
        properties.add(new Property("KeyA", "ValueA"));
        properties.add(new Property("KeyB", "ValueB"));
    }

    public List<Property> findPropertyEntities() {
        // Copy list and entries to prevent direct in-memory updating
        List<Property> newList = new ArrayList<Property>();
        for (Property property : properties) {
            newList.add(new Property(property.getPropKey(), property.getPropValue()));
        }

        return newList;
    }

    public void update(Property updatedProperty) {
        for (Property property : properties) {
            if (property.getPropKey().equals(updatedProperty.getPropKey())) {
                property.setPropValue(updatedProperty.getPropValue());
            }
        }
    }
}