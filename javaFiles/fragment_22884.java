@Component
@ConfigurationProperties("app.repository")
@Data
public class AppRepositoryConfig {
    private boolean exportStudy = true;
    private boolean exportSample = true;
    ...
}