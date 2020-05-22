CloudSolrServer server = new CloudSolrServer("192.112.21.21:9983");
server.setZkConnectTimeout(15*60*1000); 
server.setZkClientTimeout(15*60*1000); 
server.setParser(new BinaryResponseParser()); 
server.setRequestWriter(new BinaryRequestWriter());
CollectionAdminRequest adminRequest = new CollectionAdminRequest(); 
adminRequest.setAction(CollectionAction.CLUSTERSTATUS); 
CollectionAdminResponse adminResponse = adminRequest.process(server); 
System.out.println(adminResponse.toString());