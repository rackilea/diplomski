public class E2ESRInvoiceTest {
    WebDriver driver;
    Ourfsnlogin LoginPage;
    SRCreate SRCreatePage;
    InvoicingPOF Invoicing;
    HomePagePOF HomePage;
    HomePagePOFSC HomePageSC;
    Utilities UtilClass;

    private String cachedSrnumber;

    @BeforeSuite
    public String beforeTest() throws InterruptedException {
        if(cachedSrnumber != null)
            return cachedSrnumber;

        // Your beforeTest() code

        cachedSrnumber = srnumber;
        return srnumber;
    }
}