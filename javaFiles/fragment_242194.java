public class MyEnumConverter implements Converter {

    public static MyEnumConverter getInstance() {
    return new MyEnumConverter();
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) {
         writer.setValue(((MyEnum) value).name());
    }

    //method that return the enum value by string
    //if value equals return the correct enum value
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        return MyEnum.get(reader.getValue()); //method get implemented in enum
    }

    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class clazz) {
        return MyEnum.class.isAssignableFrom(clazz);
    }
}