@RunWith(Parameterized.class)
public class GoogleSearchClass {

    private String searchString;
    private String expectedString;
    public GoogleSearchClass (String srch, String expect){
        searchString = srch;
        expectedString = expect;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"search1", "expected1"}, {"search2", "expected2"}, {"search3", "expected3"}
        });
    }

    @Test
    public void testGoogleSearch() throws Exception {
        driver.get("http://google.com");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys(searchString); // Input text from String array here
        driver.findElement(By.id("gbqfb")).click();

        try {
         //   Assert.assertEquals(expectedString, driver.findElement(By.id("gbqfq")).getAttribute("value"));
        } catch (AssertionError e) {
        }
    }
}