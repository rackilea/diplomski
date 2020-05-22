static {
    Network network = Network.newNetwork()
    dgraph_zero = new GenericContainer<>("dgraph/dgraph")
            .withExposedPorts(5080)
            .withNetworkAliases("zero")
            .withStartupTimeout(Duration.of(1, ChronoUnit.MINUTES))
            .withCommand("dgraph zero --my=zero:5080")
            .withNetwork(network)
            .waitingFor(Wait.forLogMessage('.* Updated Lease id: 1.*\\n',1))
    dgraph_zero.start()

  dgraph_alpha = new GenericContainer<>("dgraph/dgraph")
        .withExposedPorts(9080)
        .withStartupTimeout(Duration.of(1, ChronoUnit.MINUTES))
        .withNetworkAliases("alpha")
        .withCommand("dgraph alpha --my=alpha:7080 --lru_mb=2048 --zero=zero:5080")
        .withNetwork(network)
        .waitingFor(Wait.forLogMessage(".*Server is ready.*\\n",1))
    dgraph_alpha.start()

    this.address = dgraph_alpha.containerIpAddress
    this.port1 = dgraph_alpha.getMappedPort(9080)

    ManagedChannel channel = ManagedChannelBuilder
            .forAddress(address,port1)
            .usePlaintext()
            .build();
    DgraphGrpc.DgraphStub stub = DgraphGrpc.newStub(channel);
    this.dgraphclient = new DgraphClient(stub) ;
    Transaction txn = this.dgraphclient.newTransaction();