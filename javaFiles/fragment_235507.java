package com.Server;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Subnet
{
    public void Subnet() throws UnknownHostException, SocketException
    {
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                String ip = i.getHostAddress();

                String sip = ip.substring(0, ip.indexOf('.',ip.indexOf('.',ip.indexOf('.')+1) + 1) + 1);
                try {
                    for(int it=1;it<=255;it++)
                    {
                        String ipToTest = sip+it;
                        boolean online = InetAddress.getByName(itToTest).isReachable(100);
                        if (online) {
                            System.out.println(ipToTest+" is online");
                        }

                    }
                } catch (IOException e1) {
                    System.out.println(sip);
                }
            }
        }
    }
}