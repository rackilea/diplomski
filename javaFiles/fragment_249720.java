@Component
public class MyComponent {

    private static String directory;

    @Value("${filesystem.directory}")
    public void setDirectory(String value) {
        this.directory = value;
    }
}