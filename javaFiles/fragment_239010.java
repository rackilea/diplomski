@Startup
@Singleton
public class Deploytime
{
  private LocalDateTime starttime;

  @PostConstruct
  public void init() {
    starttime = LocalDateTime.now();
  }
}