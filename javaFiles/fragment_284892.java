private Proxy findProxy(URI uri)
{
   try
   {
      ProxySelector selector = ProxySelector.getDefault();
      List<Proxy> proxyList = selector.select(uri);
      if (proxyList.size() > 1)
           return proxyList.get(0);
   }
   catch (IllegalArgumentException e)
   {
   }
   return Proxy.NO_PROXY;
}