public interface RemoteDatabase extends Remote {
    public String getProperty() throws RemoteException;
    public void insertData(String data) throws RemoteException;
}

public class RemoteDatabaseImpl implements RemoteDatabase {
    @Override
    public void insertData(String data) throws RemoteException {
        // whatever
    }

    @Override
    public String getProperty() {
        return "whatever";
    }

    public Database toLocal() throws NoSuchObjectException {
        return new Database((RemoteDatabase) PortableRemoteObject.toStub(this), getProperty());
    }
}

public class Database implements RemoteDatabase, Serializable {
    private final RemoteDatabase remote;
    private final String property;

    public Database(RemoteDatabase remote, String property) {
        this.remote = remote;
        this.property = property;
    }

    @Override
    public String getProperty() {
        return property;
    }

    @Override
    public void insertData(String data) throws RemoteException {
        remote.insertData(data);
    }
}