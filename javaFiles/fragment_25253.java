@Component
@ConfigurationProperties("mainConfig")
public class AppProperties {

  private Map<String, ListItem> listItems;

  public static class ListItem {

    private String listingName;
    private String property1;
    private String property2;
    private String storageProp;

    // setters, getters
  }

  // setters, getters
}