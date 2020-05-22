RemoteRef   remoteRef;
if (stub instanceof RemoteStub)
{
    remoteRef = ((RemoteStub)stub).getRef();
}
else
{
    // dynamic proxy
    RemoteObjectInvocationHandler   roih = (RemoteObjectInvocationHandler)java.lang.reflect.Proxy.getInvocationHandler(stub);
    remoteRef = roih.getRef();
}
if (remoteRef instanceof sun.rmi.server.UnicastRef2)
{
    // JRMP stub with client socket factory.
    // NB UnicastRef.getLiveRef() was added somewhere between 1.3 and 1.6.
    // Previously it was only obtainable via reflection.
    RMIClientSocketFactory csf = ((sun.rmi.server.UnicastRef2)remoteRef).getLiveRef().getClientSocketFactory();
    // YOUR CODE GOES HERE
    // Note that 'csf' can still be null here, if you exported the remote object with an *explicitly null* client socket factory parameter.
}