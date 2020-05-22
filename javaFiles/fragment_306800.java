@Module
public class ModuleUtil {

    @Provides
    public RestTemplate provideRestTemplate() {
        return new RestTemplate();
    }

}

@Singleton
@Component(
        modules = {
                ModuleUtil.class
        })
public interface MainComponent {
    void inject(Postman postman);
}