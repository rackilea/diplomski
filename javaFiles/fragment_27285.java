@org.osgi.service.component.annotations.Component(
    name = "camel_config", configurationPid=camel",
    configurationPolicy = ConfigurationPolicy.REQUIRE
)
@Designate(ocd=MyConfig.class)
public class ConfigReaderFactory {
    ...
}