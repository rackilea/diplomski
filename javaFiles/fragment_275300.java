MyEntityType met = ...;
EntityAdapter adapter = new EntityAdapter();
EntityComplexType ect = adapter.marshal( met );
ObjectFactory of = new ObjectFactory();
JAXBElement<EntityComplexType> jbe = of.createEntityComplexType( ect );
JAXBContext jc = JAXBContext.newInstance( PACKAGE );
Marshaller m = jc.createMarshaller();
m.marshal( jbe, ... );