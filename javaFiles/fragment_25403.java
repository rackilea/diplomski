TMultiplexedProcessor processor = new TMultiplexedProcessor();

processor.registerProcessor(
    "AddService",
    new AddService.Processor(new AddHandler()));

processor.registerProcessor(
    "MultiplyService",
    new MultiplyService.Processor(new MultiplyHandler()));

TServerTransport serverTransport = new TServerSocket(7911);

TTransportFactory factory = new TFramedTransport.Factory();

TServer.Args args = new TServer.Args(serverTransport);
args.processor(processor);
args.transportFactory(factory);
TSimpleServer server = new TSimpleServer(args);

System.out.println("Starting server on port 7911 ...");
server.serve();