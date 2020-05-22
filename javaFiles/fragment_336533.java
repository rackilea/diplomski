@Configuration
@Profile("production")
@ComponentScan(basePackages = { "com.packagename" })
@PropertySource({"classpath:packagename.properties"})
public class ContextConfig {

  @Autowired
  private Environment env;

  @Bean
  public ISomeIfaceDao iSomeIfaceDao() {
    return new ISomeIfaceDaoImpl(env.getRequiredProperty("someotherproperty"));
  }
}