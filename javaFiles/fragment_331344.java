public class RdbmsBasedAddrBookStore implements AddrBookStore {
    private Connection connection;

    @Inject
    public RdbmsBasedAddrBookStore(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Contact getContactByKey(String key) throws AddrBookException
    {}

    @Override
    public void addContact(Contact c) throws AddrBookException
    {}
}