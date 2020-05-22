public class HeaderFilter implements ClientResponseFilter {


  private Map<String, String> headers = new HashMap<>();

  private List<String> headerFilter = new ArrayList<>();


  public final void addHeaderFilter(final String header) {

      headerFilter.add(header);
  }

  public final void removeHeaderFilter(final String header) {

      headerFilter.remove(header);
  }

  public final String getHeader(final String header) {

      return headers.get(header);
  }

  @Override
  public final void filter(final ClientRequestContext requestContext,
          final ClientResponseContext responseContext) 
                                      throws IOException {

      headers = new HashMap<>();

      for (String headerToLookFor : headerFilter) {

          String header = responseContext.getHeaderString(headerToLookFor);

          if (header != null) {

              headers.put(headerToLookFor, header);
          } else {

              ...
          }
      }
  }
}