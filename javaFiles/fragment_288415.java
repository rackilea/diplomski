public final class FooEndpoint implements Endpoint {
  private String url;

  public void setUrl(String url) {
    this.url = url;
  }

  @Override public String getName() {
    return "default";
  }

  @Override public String getUrl() {
    if (url == null) throw new IllegalStateException("url not set.");
    return url;
  }
}