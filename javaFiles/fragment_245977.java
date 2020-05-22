ArrayList<String> stringList = new ArrayList<String>();  //example list
stringList.add("abc"); //example data
stringList.add("abc"); //example data
stringList.add("abc"); //example data
stringList.add("abc"); //example data

XStream xstream = new XStream();
xstream.alias("string", String.class ); //example aliasing

Mapper mapper = xstream.getMapper();

CollectionConverter aColCon = new CollectionConverter(mapper) {

    @Override
    protected void writeItem(Object item, MarshallingContext context, HierarchicalStreamWriter writer){
        super.writeItem(item, context, writer);
        System.out.println("write object item"+item);
        //TODO your progress bar here!

    }
};

xstream.registerConverter(aColCon);
String asXml = xstream.toXML(stringList);
System.out.println(asXml);