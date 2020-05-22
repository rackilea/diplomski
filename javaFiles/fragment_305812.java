MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory, context);
converter.setTypeMapper(mapper);
converter.setCustomConversions(new CustomConversions(
        Arrays.asList(
                new TimeZoneReadConverter(),
                new TimeZoneWriteConverter()
        )
));
converter.afterPropertiesSet();
MongoTemplate template = new MongoTemplate(mongoDbFactory, converter);