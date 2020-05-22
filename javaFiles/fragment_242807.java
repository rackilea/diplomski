m_Ipports.setSSLStartMode(Ipports.sslImplicit);
m_Ipports.setTimeout(60);
m_Ipports.setRemoteHost(host);
m_Ipports.setRemotePort(port);
m_Ipports.setConnected(true);

NetworkInputStream nis = new NetworkInputStream(m_Ipports);
m_Ipports.setAcceptData(true);
m_Ipports.send(dataToSend);   
ObjectInputStream ois = new ObjectInputStream(nis);
Object resp = ois.readObject();
m_Ipports.setAcceptData(false);
m_Ipports.setReceiveStream(null);
Map m = (Map)o;