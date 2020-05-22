ArrayList<String> IPtable=new ArrayList<String>();
QueryXML getNodes = new QueryXML(Queries);
NodeList IPs = getNodes.query();
 for (int n=0; n<IPs.getLength();n++){
  String ip =IPs.item(n).getNodeValue();
   IPtable.add(ip);
}
ArrayList<String> IPSubnet=new ArrayList<String>();
QueryXML getSubnets = new QueryXML(Queries1);
NodeList subnets = getSubnets.query();
 for (int s=0; s<subnets.getLength();s++){
String subnet =subnets.item(s).getNodeValue();
     IPSubnet.add(subnet);

}