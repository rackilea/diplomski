@Guice
public class TestClass {
    @Test(dataProvider = "get", dataProviderClass=TestDataProvider.class)
    public void test1(String s1, String s2) {
        Assert.assertEquals(s1.length(), s2.length());
    }
}