@Bean
public CustomConversions customConversions(){
    List<Converter<?,?>> converters = new ArrayList<Converter<?,?>>();
    converters.add(new DateToZonedDateTimeConverter());
    converters.add(new ZonedDateTimeToDateConverter());
    return new CustomConversions(converters);
}

@Bean
public MongoTemplate getMongoTemplate() throws UnknownHostException {
    MappingMongoConverter converter = new MappingMongoConverter(
            new DefaultDbRefResolver(getMongoDbFactory()), new MongoMappingContext());
    converter.setCustomConversions(customConversions());
    converter.afterPropertiesSet();
    return new MongoTemplate(getMongoDbFactory(), converter);
}

class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {

     @Override
     public ZonedDateTime convert(Date source) {
              return source == null ? null : ofInstant(source.toInstant(), systemDefault());
         }
     }

class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {

    @Override
    public Date convert(ZonedDateTime source) {
             return source == null ? null : Date.from(source.toInstant());
       }
   }