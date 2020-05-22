@Singleton
public class JobsManager extends GuiceJobManager {

    @Inject
    public JobsManager(Injector injector, JobsAppConfiguration configuration) {
        super(injector);
        configure(configuration);
    }
}