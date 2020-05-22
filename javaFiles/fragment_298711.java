public class AquiferPublicDataTest {

    @Test
    public void testConstructor_Success() {
        // setup 
        String name = "Jones";
        // exercise
        AquiferPublicData data = new AquiferPublicData(name, 0.0);
        // assert
        Assert.assertEquals(name, data.getMyName());
    }

    @Test(expects = HydricDSSException.class)
    public void testConstructor_NameTooLong() throws HydricDSSException {
        // setup 
        String name = "this one is too long";
        // exercise
        new AquiferPublicData(name, 0.0);
    }
}