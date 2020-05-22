public class zeus extends Application {
    private SecurityDao securityDao;

    public zeus() {
        securityDao = new SecurityDao();
    }

    @Override
    public Restlet createInboundRoot() {
        (...)

        UserVerifier verifier = new UserVerifier();
        verifier.setSecurityDao(securityDao);

        (...)
        return guard;
    }
}