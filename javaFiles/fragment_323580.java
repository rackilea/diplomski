@Dependent
public class SettingRepository {
    @Inject
    private Logger logger;

    private EntityManager entityManager;

    public void initialize(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    ...
}