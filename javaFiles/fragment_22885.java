@Configuration
@RequiredArgsConstructor
public class AppRepositoryDetectionStrategyConfig extends RepositoryRestConfigurerAdapter {

    @NonNull private AppRepositoryConfig appRepositoryConfig;

@Override
public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    RepositoryDetectionStrategy rds = config.getRepositoryDetectionStrategy();

    config.setRepositoryDetectionStrategy(
            repositoryDetectionStrategy(rds)
    );
}

private RepositoryDetectionStrategy repositoryDetectionStrategy(
        RepositoryDetectionStrategy repositoryDetectionStrategy) {
    RepositoryDetectionStrategy rds = metadata -> {

            boolean defaultExportSetting = repositoryDetectionStrategy.isExported(metadata);

            if  (metadata.getDomainType().equals(Study.class)) {
                return (appRepositoryConfig.isExportStudy()) ? defaultExportSetting : false; 
            }
            ...
            return defaultExportSetting;
    };

    return rds;
}