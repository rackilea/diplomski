public interface RemoteDatabase extends Remote {
    public void insertData(String data) throws RemoteException;
}

public class RemoteDatabaseImpl implements RemoteDatabase {
    @Override
    public void insertData(String data) throws RemoteException {
        // whatever
    }
}

public class Database implements Serializable {
    private final RemoteDatabase remote;
    private final String property;

    public Database(RemoteDatabase remote, String property) {
        this.remote = remote;
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void insertData(String data) throws RemoteException {
        remote.insertData(data);
    }
}