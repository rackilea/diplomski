static Registry registry;

// ...
registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
// ...
public Main() throws RemoteException
{
    super(Registry.REGISTRY_PORT);
    // ...
}

// ....
Main main = new Main();
registry.rebind("RmiServer", main);