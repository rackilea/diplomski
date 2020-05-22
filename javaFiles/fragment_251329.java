public class Testcase1 extends Registration {

TNGDriver objTND = new TNGDriver();

    @BeforeTest
    public void initializeDriver(){
    objTND.DriverConfiguration();  
    }

    @Test(priority = 1) 
    public void step1_checkSomething() {        
        //do something
    }

    @Test(priority = 2)
    public void step2_clickOnSomething() {          
        //click on something            
    }

    @AfterTest
    public void initializeDriver(){
    objTND.QuitDriver();  
    }
}