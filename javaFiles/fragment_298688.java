public Converter lookupConverterForType(Class type) {
    Converter cachedConverter = (Converter) typeToConverterMap.get(type);
    if (cachedConverter != null) return cachedConverter;
    Iterator iterator = converters.iterator();
    while (iterator.hasNext()) {
        Converter converter = (Converter) iterator.next();
        if (converter.canConvert(type)) {
            typeToConverterMap.put(type, converter);
            return converter;
        }
    }
    throw new ConversionException("No converter specified for " + type);
}