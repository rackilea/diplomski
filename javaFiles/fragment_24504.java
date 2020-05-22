package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MultiDns
{
    public static void main(String[] args)
    {
        try
        {
            String hostname = "www.google.com";
            System.out.printf("Hostname: %s%n",hostname);
            for (InetAddress addr : InetAddress.getAllByName(hostname))
            {
                System.out.printf(" - %s [%s]%n",addr.getHostAddress(),InetAddress.getByAddress(addr.getAddress()).getHostName());
            }
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}