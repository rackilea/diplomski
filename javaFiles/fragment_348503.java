private class ServiceListenerImpl implements ServiceListener
{
  @Override
  public void serviceAdded(ServiceEvent serviceEvent)
  {    
    serviceEvent.getDNS().requestServiceInfo(serviceEvent.getType(), serviceEvent.getName());
  }

  @Override
  public void serviceRemoved(ServiceEvent serviceEvent)
  {
    //Handle service dropping out.
  }

  @Override
  public void serviceResolved(ServiceEvent serviceEvent)
  {
    Socket socket = new Socket(
      new InetSocketAddress(serviceEvent.getInfo().getInetAddress(), serviceEvent.getInfo().getPort())
    ).open();

    ...
  }
}