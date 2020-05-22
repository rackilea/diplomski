ModelMapper mapper = new ModelMapper();
TypeMap<Foo, FooModel> typeMap = mapper.createTypeMap(Foo.class, FooModel.class);
Converter<TimeZone, String> tzConverter = ctx -> ctx.getSource().getID() + "!!!";
typeMap.addMappings(map -> {
    map.using(tzConverter).map(Foo::getTimeZone, FooModel::setTimeZoneId);
});

Foo foo = new Foo();
foo.setTimeZone(TimeZone.getDefault());

FooModel model = mapper.map(foo, FooModel.class);
System.out.println(model.getTimeZoneId()); // "Europe/Berlin!!!" here