HttpServer server = ...
// The default network listener is named grizzly when 
// creating a server via the factory method
NetworkListener l = server.getNetworkListener("grizzly");
TCPNIOTransport transport = l.getTransport();

// You can make changes to the kernel thread pool
// by calling transport.getKernelThreadPoolConfig().
// Changes to the worker thread pool via
// transport.getWorkerThreadPoolConfig().