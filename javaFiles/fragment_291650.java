ModelMapper mapper = new ModelMapper();

TypeMap<Bar, Foo> barToFooMapping = mapper.createTypeMap(Bar.class, Foo.class);
barToFooMapping.addMappings(mapping -> mapping.using(DATE_TO_LOCAL_DATE_CONVERTER).map(Bar::getSignatureDate, Foo::setSignatureDate));
TypeMap<Foo, Bar> fooToBarMapping = mapper.createTypeMap(Foo.class, Bar.class);
fooToBarMapping.addMappings(mapping -> mapping.using(LOCAL_DATE_TO_DATE_CONVERTER).map(Foo::getSignatureDate, Bar::setSignatureDate));