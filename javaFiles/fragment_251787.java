public class AuroraRepoImpl {
  private final Connector4AuroraDB connector;

  @Autowired
  public AuroraRepoImpl(final Connector4AuroraDB connector) {
    this.connector = connector;
  }
}