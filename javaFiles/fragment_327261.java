public class Filters implements ApplicationFilters {
  @Override
  public void addFilters (List<Class<? extends Filter>> list) {
    list.add (HttpsFilter.class);
  }
  public static class HttpsFilter implements Filter {
    @Override
    public Result filter (FilterChain filterChain, Context context) {
      if ("http".equals (context.getHeader ("X-Forwarded-Proto"))) {
        return Results.redirect ("https://" + context.getHostname ()
          + context.getRequestPath ());
      }
      return filterChain.next (context);
    }
  }
}