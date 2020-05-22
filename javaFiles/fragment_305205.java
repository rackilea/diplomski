private Enumeration<NetworkInterface> networkInterfaces = null;
   private Enumeration<InetAddress> networkAddresses = null;

   ...
        try
        {
            while(true)
            {
                if(this.networkInterfaces == null)
                {
                    networkInterfaces = NetworkInterface.getNetworkInterfaces();
                }
                if(networkAddresses == null || !networkAddresses.hasMoreElements())
                {
                    if(networkInterfaces.hasMoreElements())
                    {
                        NetworkInterface networkInterface = networkInterfaces.nextElement();
                        networkAddresses = networkInterface.getInetAddresses();
                    }
                    else
                    {
                        networkInterfaces = null;
                    }
                }
                else
                {
                    if(networkAddresses.hasMoreElements())
                    {
                        String address = networkAddresses.nextElement().getHostAddress();
                        if(address.contains(".")) //IPv4 address
                        {
                            textView.setText(address);
                        }
                        break;
                    }
                    else
                    {
                        networkAddresses = null;
                    }
                }
            }
        }
        catch(SocketException e)
        {
            e.printStackTrace();
        }