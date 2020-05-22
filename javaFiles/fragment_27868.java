@PropertySource("classpath:permission-config.yml")
@ConfigurationProperties(prefix = "myPrefix")
public class ViewUsers {
    private String value; // getter, setter
}

@PropertySource("classpath:permission-config.yml")
@ConfigurationProperties(prefix = "myPrefix2")
public class ManageUsers {
    private String value; // getter, setter
}

@Configuration
@EnableConfigurationProperties({ViewUsers.class, ManageUsers.class}
public class MySampleConfiguration {

    ... beans here...
}