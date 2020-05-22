public class Test {
    public static void analyzeBeanProperties(final Class<?> clazz) throws Exception {
        for (final PropertyDescriptor propertyDescriptor
                : Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors()) {
            System.out.println("Property name: " + propertyDescriptor.getName());
            System.out.println("Getter method: " + propertyDescriptor.getReadMethod());
            System.out.println("Setter method: " + propertyDescriptor.getWriteMethod());
            System.out.println();
        }
    }

    public static void main(final String[] args) throws Exception {
        analyzeBeanProperties(TestBean.class);
    }
}