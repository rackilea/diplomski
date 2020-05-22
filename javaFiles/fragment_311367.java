protected AbstractH2Mojo() {
    super();
    final Service tcpService = new Service("tcp", Service.getDefaultPort("tcp"), false, false);
    this.setServices(Collections.singletonList(tcpService));
    this.setPort(Service.getDefaultPort("tcp"));
    this.setShutdownPassword("h2-maven-plugin");
    this.setJava(new File(new File(new File(System.getProperty("java.home")), "bin"), "java"));
 }