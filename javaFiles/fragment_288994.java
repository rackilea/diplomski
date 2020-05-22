class ConverterConverter<T, U> implements Converter<Object, U>
{
    private final Converter<T, U> original;

    ConverterConverter(Converter<T, U> original)
    {
        this.original = original;
    }

    public U convert(Object input)
    {
        return original.convert((T) input);
    }
}

class ConverterManager {

    private Map<Key,Converter<Object,?>> converterRegistry;

    ConverterManager()
    {
        converterRegistry = new HashMap<Key, Converter<Object,?>>();
        converterRegistry.put(new Key(String.class, Integer.class),
                              new ConverterConverter<String, Integer>
                                  (new StringIntegerConverter())); 
    }   

    public <T> T convert(Object source, Class<T> toType) 
    {
        Key key = new Key(source.getClass(), toType);
        Converter<Object, ?> converter = converterRegistry.get(key);
        return (T) converter.convert(source);
    }
}