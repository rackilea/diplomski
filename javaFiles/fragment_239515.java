@RunWith(PowerMockRunner.class)
@PrepareForTest({System.class})
public class Xxx {

    @Test
    public void testThis() throws Exception {
        System.setProperty("test-prop", "test-value");
        PowerMockito.mockStatic(System.class);

        PowerMockito.when(System.getenv(Mockito.eq("name"))).thenReturn("bart");
        // you will need to do this (thenCallRealMethod()) for all the other methods
        PowerMockito.when(System.getProperty(Mockito.any())).thenCallRealMethod();

        Assert.assertEquals("bart", System.getenv("name"));

        String value = System.getProperty("test-prop");

        Assert.assertEquals("test-value", System.getProperty("test-prop"));
    }
}