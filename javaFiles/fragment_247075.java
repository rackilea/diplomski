public class Filters extends DefaultHttpFilters {
  @Inject
  public Filters(GzipFilter gzip, LoggingFilter logging) {
    super(gzip, logging);
  }
}