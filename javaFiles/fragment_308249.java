public RemoteException closeSessionAndThrow( ... )   // <-- add return type here
        throws RemoteException { ... }

public <T> T get( ... ) throws RemoteException
{
    try { ... }
    catch (final HibernateException e)
    {
        throw this.closeSessionAndThrow( ... );  // <-- add "throw" here
    }
}