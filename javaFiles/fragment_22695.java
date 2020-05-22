ObjectName connectionNames = 
      new ObjectName("org.apache.activemq:BrokerName=localhost," + 
                     "Type=Connection,ConnectorName=openwire,Connection=*");

Set<ObjectName> names = mbsc.queryNames(connectionNames, null); 
for(ObjectName name : names) { 
   logger.error("Name: "+name.getCanonicalName()); 
}