public static NetworkInterface getByInetAddress (InetAddress addr)
    throws SocketException
  {
    if (networkInterfaces == null)
      networkInterfaces = getRealNetworkInterfaces ();

    for (Enumeration interfaces = networkInterfaces.elements ();
         interfaces.hasMoreElements (); )
      {
        NetworkInterface tmp = (NetworkInterface) interfaces.nextElement ();

        for (Enumeration addresses = tmp.inetAddresses.elements ();
             addresses.hasMoreElements (); )
          {
            if (addr.equals ((InetAddress) addresses.nextElement ()))
              return tmp;
          }
      }

    throw new SocketException (
      "no network interface is bound to such an IP address");
  }