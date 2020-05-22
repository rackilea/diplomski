static final Map<Class<?>,Setter> SETTERS =Map.copyOf(Map.<Class<?>,NumericSetter>ofEntries(
    Map.entry(byte.class, (field,bean,n) -> field.setByte(bean, n.byteValue())),
    Map.entry(short.class, (field,bean,n) -> field.setShort(bean, n.shortValue())),
    Map.entry(int.class, (field,bean,n) -> field.setInt(bean, n.intValue())),
    Map.entry(long.class, (field,bean,n) -> field.setLong(bean, n.longValue())),
    Map.entry(float.class, (field,bean,n) -> field.setFloat(bean, n.floatValue())),
    Map.entry(double.class, (field,bean,n) -> field.setDouble(bean, n.doubleValue())),
    Map.entry(Byte.class, (field,bean,n) -> field.set(bean, n.byteValue())),
    Map.entry(Short.class, (field,bean,n) -> field.set(bean, n.shortValue())),
    Map.entry(Integer.class, (field,bean,n) -> field.set(bean, n.intValue())),
    Map.entry(Long.class, (field,bean,n) -> field.set(bean, n.longValue())),
    Map.entry(Float.class, (field,bean,n) -> field.set(bean, n.floatValue())),
    Map.entry(Double.class, (field,bean,n) -> field.set(bean, n.doubleValue()))
));
interface Setter {
    void set(Field field, Object bean, Object value) throws IllegalAccessException;
    Setter FALLBACK = Field::set;
}
interface NumericSetter extends Setter {
    @Override default void set(Field field, Object bean, Object value)
    throws IllegalAccessException {
        setNumeric(field, bean, (Number)value);
    }
    void setNumeric(Field f, Object bean, Number n) throws IllegalAccessException;
}