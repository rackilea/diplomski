@Component
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        registerModule(new AnyModuleYouNeed());
    }
}