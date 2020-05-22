public class TestClient {
    @Test
    public void testCfg() throws Exception {
        Configuration cgf = new Configuration().configure("/hibernate.cfg.xml");
        cgf.buildSessionFactory();
    }
}