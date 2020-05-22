import org.minidns.dnsserverlookup.android21.AndroidUsingLinkProperties;
AndroidUsingLinkProperties.setup(context);//add this
cc=XMPPTCPConnectionConfiguration.builder()
                        .setCompressionEnabled(true)
                        .setUsernameAndPassword(username,password)
                        .setXmppDomain(domain)
                        .build();
                xmpptcpConnection=new XMPPTCPConnection(cc);
                xmpptcpConnection.addConnectionListener(this);
                xmpptcpConnection.connect();
                xmpptcpConnection.login();