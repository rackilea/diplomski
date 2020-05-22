public class SolicitudEmpleo extends LaunchBrowser{
    private String campoDni;
    private String firstName;
    private String lastName;

    @Factory (dataProvider="dataProviderMethod")
    public SolicitudEmpleo(String campoDni, String firstName, String lastName){
        this.campoDni=campoDni;
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("data number"+campoDni);
    }

    @DataProvider
    public static Object[][] dataProviderMethod() {
        return new Object[][] { {"000007", "Bill", "Gates"}, {"000008", "Stack", "Overflow"} };
    }
    @Test (priority = 1)
    public void testCase1(){
        System.out.println("Test 1");  
    }
    @Test (priority = 2)
    public void testCase2() throws InterruptedException { 
        System.out.println("Test 2 "+campoDni);
    }
    @Test (priority = 3)
    public void testCase3() throws InterruptedException {
        System.out.println("Test 3 "+firstName+","+lastName);
    }
    @Test (priority = 4)
    public void testCase4() throws InterruptedException {
        System.out.println("Test 4");
    }   
}
public class LaunchBrowser {
    @BeforeSuite()
    public void launchBrowser() throws InterruptedException {
        System.out.println("Launching");
    }
}