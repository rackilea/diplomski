public class TestNGTest {    
    @Test
    @Parameters({"driver", "url"})
    public void shouldReadParametersSentFromIJ(String driver, String url) {
        System.out.println(String.format("This test would run using the [%s] driver and on the [%s] URL.", driver, url));
    }
}