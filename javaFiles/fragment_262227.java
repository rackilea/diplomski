void marshal() throws Exception {
    JAXBContext jc = JAXBContext.newInstance( "com.foo:com.bar" );
    Marshaller m = jc.createMarshaller();
    DataType data = new DataType();
    ObjectFactory of = new ObjectFactory();
    JAXBElement<DataType> jbe = of.createData(data);
    data.setChildData("child data");
    m.marshal( jbe, System.out );
}