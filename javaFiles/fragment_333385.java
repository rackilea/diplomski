public String toXML() {
    String x;
    XStream xs = new XStream();

    // the following tell XStream how to craete myData element:
    // the last arg is the field to be used as element value and all other fields are attributes
    xs.registerConverter(new ToAttributedValueConverter(MyData.class, xs.getMapper(), xs.getReflectionProvider(),
        xs.getConverterLookup(), "date"));
    // register date converter according to dateFormat field
    xs.registerConverter(new DateConverter(myData.dateFormat, new String[]{}));

    x = xs.toXML(this);
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+x;
}