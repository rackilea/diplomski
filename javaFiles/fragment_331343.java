public class ABguiceConfingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AddrBookStore.class).to(RdbmsBasedAddrBookStore.class);
        bind(Connection.class).toProvider(ConnectionProvider.class);
    }
}