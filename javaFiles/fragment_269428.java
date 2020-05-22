@Component
public class PageFactory {
    @Value("${defaultUrl}")
    private String defaultUrl;

    public Page create() {
        return new Page(defaultUrl);
    }
}