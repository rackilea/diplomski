public class ProgramCustomizer extends SessionCustomizer {
    @Override
    public void customize(Session s) throws Exception {
        s.getDatasourceLogin().setProperty("v$session.program", "Customers");
        super.customize(s);
    }
}