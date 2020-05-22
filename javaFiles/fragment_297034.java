NetworkManager edgePeerManager = new NetworkManager(NetworkManager.ConfigMode.EDGE,...);
NetworkConfigurator edgePeerConfigurator = edgePeerManager.getConfigurator();

// This is the rendezvous' IP address and listening port
RendezvouServerTCPSeed = "tcp://192.XXX.X.XX:9705";

edgePeerConfigurator.addRdvSeedingURI(RendezvouServerTCPSeed);

PeerGroup edgePeerGroup=  edgePeerManager.startNetwork();