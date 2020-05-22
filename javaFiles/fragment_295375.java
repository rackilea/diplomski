public class MongoApp {

    private static final Log log = LogFactory.getLog(MongoApp.class);

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        mongoOperation.insert(new Person("Joe", 34));
        log.info(mongoOperation.findOne(new Query(where("name").is("Joe")), Person.class));
            //mongoOps.dropCollection("person");
    }
}