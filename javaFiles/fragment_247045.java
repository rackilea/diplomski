public class ExtendedBeanELResolver extends BeanELResolver {

    @Override
    public Object getValue(ELContext context, Object base, Object property)
        throws NullPointerException, PropertyNotFoundException, ELException
    {
        if (property == null || base == null || base instanceof ResourceBundle || base instanceof Map || base instanceof Collection) {
            return null;
        }

        String propertyString = property.toString();

        if (propertyString.contains(".")) {
            Object value = base;

            for (String propertyPart : propertyString.split("\\.")) {
                value = super.getValue(context, value, propertyPart);
            }

            return value;
        }
        else {
            return super.getValue(context, base, property);
        }
    }

}