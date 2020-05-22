@Stateless
public class TestResourcesForSettings {
    @PersistenceContext(unitName = "pu1")
    private EntityManager entityManager1;

    @PersistenceContext(unitName = "pu2")
    private EntityManager entityManager2;

    @Inject
    private SettingRepository settingRepository;

    @Produces @DataSource
    public SettingRepository produceSettingRepository(InjectionPoint ip) {
        DataSource annotation = ip.getAnnotated().getAnnotation(DataSource.class);

        if (annotation.value() == DataSourceName.D1)
            settingRepository.initialize(entityManager1);
        else if (annotation.value() == DataSourceName.D2)
            settingRepository.initialize(entityManager2);

        return settingRepository;
    }