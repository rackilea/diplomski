byte[] addr = new byte[4];
addr[0] = (ipaddr >> 24) & 0xFF;
addr[1] = (ipaddr >> 16) & 0xFF;
addr[2] = (ipaddr >> 8 ) & 0xFF;
addr[3] = ipaddr & 0xFF;

InetAddress inetAddr = InetAddress.getByAddress(addr);