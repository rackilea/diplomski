final DefaultMapperFactory factory = new DefaultMapperFactory.Builder().build();

// (1) auto-mapping
// nothing here

// (2) if the scenario is simple enough
factory.classMap(MtuInterfaceMap.class, MtuInterfaceMapUI.class)
       .field("comment", "details")
       .byDefault()
       .register();

// (3) if converter is required
final String listConverterId = "listConverter";
factory.getConverterMap()
       .registerConverter(listConverterId , new MtuInterfaceMapListConverter());


// 
factory.classMap(EdgeMtuMismatchEvent.class, EdgeMtuMismatchEventUI.class)
       .fieldMap("list", "list").converter(listConverterId).add() //  for case (3) only - declare converter
       .byDefault()
       .register();

BoundMapperFacade<EdgeMtuMismatchEvent, EdgeMtuMismatchEventUI> facade =
    factory.getMapperFacade(EdgeMtuMismatchEvent.class, 
                            EdgeMtuMismatchEventUI.class, 
                            false);