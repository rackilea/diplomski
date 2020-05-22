@JacksonXmlRootElement(localName = "Settings")
public class Configuration {

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Property> property;
}