public abstract class Field<T> implements FieldType<T> {

    ...

    public <F> T convert(F value, Function<F, T> converter) {
        try {
            return converter.apply(value);
        } catch(Exception e) {
            return null;
        }
    }

    ...

}