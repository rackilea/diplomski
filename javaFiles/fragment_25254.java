@Configuration
class AppConfiguration {

  @Autowired
  private AppProperties appProperties;

  @Bean("listItem1")
  public ListItem useListItem1() {
    return appProperties.getListItems().get("listItem1");
  }

  @Bean("listItem2")
  public ListItem useListItem2() {
    return appProperties.getListItems().get("listItem2");
  }
}