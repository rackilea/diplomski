@Provider
public class DbObjectParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, 
                                              Annotation[] annotations) {

        if (rawType.getName().equals(DbObject.class.getName())) {

            return new ParamConverter<T>() {

                @Override
                public T fromString(String value) {
                    return rawType.cast(new DbObject(value));
                }

                @Override
                public String toString(T value) {
                    return ((DbObject) value).getId();
                }
            };
        }

        return null;
    }
}