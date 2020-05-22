Proxy proxy = (Proxy) ProxySelector.getDefault().select(new URI("http://www.yahoo.com/")).iterator().
      next();
System.out.println("proxy hostname : " + proxy.type());
InetSocketAddress addr = (InetSocketAddress)
proxy.address();
if (addr == null) {
   System.out.println("No Proxy");
}
else {
   System.out.println("proxy hostname : " 
   + addr.getHostName());
   System.out.println("proxy port : "
   + addr.getPort());
}