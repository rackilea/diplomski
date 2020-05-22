XStream xs = new XStream();
xs.alias("base", Base.class);
NamedMapConverter c = new NamedMapConverter(StringDictionary.class, xs.getMapper(), "val", "key", String.class, null, String.class, true, false, xs.getConverterLookup());
xs.registerConverter(c);


<base>
  <values class="com.test.StringDictionary">
    <val key="123">111</val>
    <val key="abc">aaa</val>
  </values>
</base>