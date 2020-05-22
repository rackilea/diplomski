//also, this fails for an invalid address, like "www.sjdosgoogle.com1234sd" 
       InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
      for (InetAddress address : addresses) {
        if (address.isReachable(10000))
        {   
           System.out.println("Connected "+ address);
        }
        else
        {
           System.out.println("Failed "+address);
        }
      }
          //output:*Failed www.google.com/74.125.227.114*