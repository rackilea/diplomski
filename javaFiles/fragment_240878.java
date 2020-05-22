@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = { BASE_PACKAGE })
public class MongoConfiguration extends AbstractMongoConfiguration {

    public static final String BASE_PACKAGE = "package.with.aggregates";

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI(mongoUri));
    }

    // Here you must add converters to Joda datetypes. In my solution is ZonedDateTime
    @Override
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new DateToZonedDateTimeConverter());
        converterList.add(new ZonedDateTimeToDateConverter());
        return new CustomConversions(converterList);
    }

    @Override
    protected String getMappingBasePackage() {
        return BASE_PACKAGE;
    }
}