for(int i=0; i< ipaddrs.length ; i++)
{
  // Or you can validate by your way(for exp: checking url ), here is checking null or empty
  if (ipaddrs[i] != null && !ipaddrs[i].isEmpty())
      art.setOutputs(ipaddrs[i], false);
}