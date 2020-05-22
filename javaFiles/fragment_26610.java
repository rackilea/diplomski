ModelMapper mapper = new ModelMapper();

Foo foo = new Foo();
foo.setTimeZone(TimeZone.getDefault());

FooModel model = mapper.map(foo, FooModel.class);
System.out.println(model.getTimeZoneId()); // "Europe/Berlin" here