// Passing factory dependency via constructor injection
public PortChecker(IServerSocketFactory socketFactory)
{
    this.socketFactory = socketFactory;
}

// ...
ServerSocket ss = this.socketFactory.GetServerSocket(port.getPortNumber());
ss.getLocalPort();
ss.close();