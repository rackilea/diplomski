TServerSocket serverTransport = new TServerSocket(7911);  // new server on port 7911
HelloWorldService.Processor<Iface> processor = new HelloWorldService.Processer<Iface>(new ThriftServerImpl());  // This is my thrift implementation for my server
Map<String, String> saslProperties = new HashMap<String, String>();  // need a map for properties
saslProperties.put(Sasl.QOP, "true");
saslProperties.put(Sasl.QOP, "auth-conf");  // authorization and confidentiality

TSaslServerTransport.Factory saslTransportFactory = new TSaslServerTransport.Factory();     // Creating the server definition
saslTransportFactory.addServerDefinition(
            "GSSAPI",       //  tell SASL to use GSSAPI, which supports Kerberos
            "myserviceprincipal",   //  base kerberos principal name - myprincipal/my.server.com@MY.REALM 
            "my.server.com",    //  kerberos principal server - myprincipal/my.server.com@MY.REALM
            saslProps,      //  Properties set, above
            new SaslRpcServer.SaslGssCallbackHandler()));  //  I don't know what this really does... but I stole it from Hadoop and it works.. so there.

Tserver server = new TThreadPoolServer(newTThreadPoolSErver.Args(serverTransport).transportFactory(saslTrasnportFactory).processor(processor));

server.serve();   // Thrift server start