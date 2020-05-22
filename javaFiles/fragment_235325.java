Map<String, String> fieldMap = new HashMap<>();
fieldMap.put("names{fullName}", "personalNames{key}");
fieldMap.put("names{}", "personalNames{value}");
MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).dumpStateOnException(false).build();
// Swap Person, PersonDto generic arguments.
ClassMapBuilder<PersonDto, Person> classBuilder = mapperFactory.classMap(PersonDto.class, Person.class);
fieldMap.forEach((k, v) -> classBuilder.field(v, k));
classBuilder.register();
// rest of the code is the same