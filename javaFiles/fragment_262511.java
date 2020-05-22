public class ProvidesModule extends AbstractModule {
    @Provides
    IClientWrapper clientWrapper(@Named("server.ip") String ip,
                                 @Named("server.port") int port) {
       return new ClientWrapper(ip, port);
    }
}