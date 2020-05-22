public class JAXBTest {
    @Test
    public void testContextLoad() throws Exception {
        final JAXBContext context = JAXBContext
            .newInstance("test.jaxb.one:test.jaxb.two");
        Assert.assertNotNull(context);
    }
}