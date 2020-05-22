@Configuration
// Not define in example so commented @ContextConfiguration(classes= 
//{PropertiesContext.class})
@ComponentScan(basePackages = "com.company.project")
public class CucumberContext {

@Autowired
private String browser;

  @Bean(name = "webdriver", destroyMethod = "quit")
  @Scope("cucumber-glue")
  public WebDriver getWebDriver() {
      WebDriver webdriver = null;
      // Removed the factory initialization code. Used simple ChromeDriver
      webdriver = new ChromeDriver();
      return webdriver;
  }
}