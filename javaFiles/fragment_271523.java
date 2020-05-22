public class PropertyMapGenerator {
    public static Map<String, Object> getPropertyMap(Object object) {
    HashMap<String, Object> propertyMap = new HashMap<>();

    // retrieve descriptors for all properties
    PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(object);

    for (PropertyDescriptor descriptor : descriptors) {
        // check if there is a reader method for this property i.e. if it can be accessed
        if (descriptor.getReadMethod() != null) {
            String name = descriptor.getName();
            try {
                propertyMap.put(name, PropertyUtils.getProperty(object, name));
            } catch (Exception e) {
                // handle this properly
                e.printStackTrace();
            }
        }
    }

    return propertyMap;
    }
}