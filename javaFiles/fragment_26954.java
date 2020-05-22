static Inet6Address getInet6AddressByName(String host) throws UnknownHostException, SecurityException
{
    for(InetAddress addr : InetAddress.getAllByName(host))
    {
        if(addr instanceof Inet6Address)
            return (Inet6Address)addr;
    }
    throw new UnknownHostException("No IPv6 address found for " + host);
}