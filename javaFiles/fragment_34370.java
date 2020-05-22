@Profile(ProfileDefinitions.MY_ENABLED_PROFILE)
@Configuration
@Import({these will only be imported if the profile is active!})
public class DatabaseDataStoreConfiguration {
}

@Profile(ProfileDefinitions.ACTIVE_WHEN_MY_IS_NOT)
@Configuration
@Import({if any are necessary})
public class DataStoreConfiguration {
}