@Entity
@Table(name = "Release")
public class Release implements Serializable
{
  @Transient
  private static ServletContext servletContext;

  @PostConstruct
  public void init() {
    log.info("Initializing ServletContext as [" +
                Release.servletContext + "]"); //Forces injection after bean construction.
  }

  @Autowired
  public void setServletContext(ServletContext servletContext) {
    Release.servletContext = servletContext; //Note the use of class name because that fiels hould be static thus shared by all instances.
  }
  //...
}