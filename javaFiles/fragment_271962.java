public class MyJLabelConverter implements Converter {

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return null;
    }

    @Override
    public boolean canConvert(Class clazz) {
        return clazz.equals(JLabel.class);
    }
}