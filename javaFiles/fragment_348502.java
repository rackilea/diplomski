ServiceInfo serviceInfo = ServiceInfo.create(
  "_exp._tcp.local.",
  "example",
  "5001",
  "Example Service"
);

JmDNS jmdns = JmDNS.create();
jmdns.registerService(serviceInfo);