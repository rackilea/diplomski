@Singleton
public class HeavyObject {

    @Inject
    private Configuration conf;

    @PostConstruct
    private void configure() {
        // make something with the conf
    }

}