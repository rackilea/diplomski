public String toShortString()
{
  return
    IpAddr.toString(getSrcAddr())+"."+getSrcPort()+" -> "+
    IpAddr.toString(getDstAddr())+"."+getDstPort()+" "+
    getDOctets();
}