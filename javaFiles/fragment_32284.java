XStream xs = new XStream();
xs.alias("base", Base.class);

xs.addDefaultImplementation(StringDictionary.class, Map.class);
NamedMapConverter c = new NamedMapConverter(xs.getMapper(), "val", "key", String.class, null, String.class, true, false, xs.getConverterLookup())
{
    public boolean canConvert(Class type)
    {
        if (type.equals(StringDictionary.class)) return true;
        else return super.canConvert(type);
    }
};
xs.registerConverter(c);