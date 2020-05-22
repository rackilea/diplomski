public class MyAsyncHttpClientConfig extends AsyncHttpClientConfig
{
  private final AsyncHttpClientConfig config;
  private ProxyServerSelector proxyServerSelector;

  public MyAsyncHttpClientConfig(AsyncHttpClientConfig config)
  {
    this.config = config;
  }

  @Override
  public int getMaxTotalConnections() { return config.maxTotalConnections; }

  @Override
  public int getMaxConnectionPerHost() { return config.maxConnectionPerHost; }

  // delegate the others but getProxyServerSelector()

  ...

  @Override
  public ProxyServerSelector getProxyServerSelector()
  { 
    return proxyServerSelector == null 
      ? config.getProxyServerSelector()
      : proxyServerSelector; 
  }

  public void setProxyServerSelector(ProxyServerSelector proxyServerSelector) 
  { 
    this.proxyServerSelector = proxyServerSelector;
  }
}