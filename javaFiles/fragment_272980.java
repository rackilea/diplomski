TTransport transport = new TSocket("my.server.com", 7911);   // client to connect to server and port
saslProperties.put(Sasl.QOP, "true");
saslProperties.put(Sasl.QOP, "auth-conf");  // authorization and confidentiality

TTransport saslTransport = new TSaslTransport(
            "GSSAPI",       //  tell SASL to use GSSAPI, which supports Kerberos
            null,           //  authorizationid - null
            "myserviceprincipal",   //  base kerberos principal name - myprincipal/my.client.com@MY.REALM 
            "my.server.com",    //  kerberos principal server - myprincipal/my.server.com@MY.REALM
            saslProps,      //  Properties set, above
            null,           //  callback handler - null
            transport);     //  underlying transport

TProtocol protocol = new TBinaryProtocol(saslTransport);    // set up our new Thrift protocol

HelloWorldService.Client client = new HelloWorldService.Client(protocol);   // Setup our thrift client
saslTransport.open();

String response = client.hello("Hi There");   // send message

System.out.println("response = " + response);

transport.close();