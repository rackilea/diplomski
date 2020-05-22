// create a new server listening on port 8000
JmxServer jmxServer = new JmxServer(8000);
// start our server
jmxServer.start();
// register our lookupCache object defined below
jmxServer.register(lookupCache);
jmxServer.register(someOtherObject);
// stop our server
jmxServer.stop();