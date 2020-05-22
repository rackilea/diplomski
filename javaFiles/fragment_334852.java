public class PropertyAdapter extends XmlAdapter<PropertyAdapter.AdaptedProperties, 
                                                HashMap<String, PropertyObject>> {

    public static class AdaptedProperties {
        public ArrayList<PropertyObject> property = new ArrayList<>();
    }

    @Override
    public HashMap<String, PropertyObject> unmarshal(
                        PropertyAdapter.AdaptedProperties list) throws Exception {

        HashMap<String, PropertyObject> map = new HashMap<>();
        for (PropertyObject prop: list.property) {
            map.put(prop.getName(), prop);
        }
        return map;
    }

    @Override
    public PropertyAdapter.AdaptedProperties marshal(
                           HashMap<String, PropertyObject> map) throws Exception {

        ArrayList<PropertyObject> list = new ArrayList<>(map.values());
        AdaptedProperties props = new AdaptedProperties();
        props.property = list;
        return props;
    }
}