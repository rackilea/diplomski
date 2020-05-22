package main.java.Functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 
 * This class is used for testing all the indo functionalities.
 * 
 * @author Ola
 */

public class Test_Run {
    /**
     * Variables to set up driver and browser.
     */
    public static AllMethods callMethod;
    public static WebDriver driver;
    public static String ID;
    public static String filePath = "C:\\Users\\Ola\\workspace\\Config.properties";

    /**
     * Setup method to run chrome browser
     * 
     * @param args
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {

        callMethod = new AllMethods();
        callMethod.setup();
        callMethod.driver.get("http://independent.ie");
        // Maximize browser window
        callMethod.driver.manage().window().maximize();
        // store current url in a string
        String site = callMethod.driver.getCurrentUrl();
        // print out the URL in the console
        System.out.println("The current Url IS: " + site);
        // Get the OS on which the driver is running.......
        String detectOS = log.DetectOS();
        log.log(detectOS);
        Thread.sleep(7000);
    }

    @After
    public void tearDown() {
        callMethod.close();
    }

    /**
     * Verifies my profile updated NATIVELY
     * 
     * @throws Exception
     * @author Ola
     */
    @Test
    public void verifyAcct_ProfileUpdated() throws Exception {
        log.header("........ Verify MY ACCOUNT PROFILE section ........");
        String finalResponse = callMethod.profileSection(
                callMethod.parseConf_File("EMAIL_ADDRESS"),
                callMethod.parseConf_File("NATIVE_PASSWORD"),
                callMethod.parseConf_File("DISPLAY_NAME"),
                callMethod.parseConf_File("FIRST_NAME"),
                callMethod.parseConf_File("LAST_NAME"),
                callMethod.parseConf_File("ADDRESS_1"),
                callMethod.parseConf_File("ADDRESS_2"),
                callMethod.parseConf_File("CITY"),
                callMethod.parseConf_File("COUNTRY"),
                callMethod.parseConf_File("COUNTRY_2"),
                callMethod.parseConf_File("COUNTY"),
                callMethod.parseConf_File("COUNTY_2"),
                callMethod.parseConf_File("POSTCODE"),
                callMethod.parseConf_File("TELEPHONE"));

        if (finalResponse.contains("DOES NOT Exist")) {
            log.log("User DOES NOT Exist in Database.... You will have to Sign Up.");

        } else if (finalResponse.contains("FACEBOOK")) {
            log.log("User Exist in Database with FACEBOOK Social Account and "
                    + "Cannot Sign Up Natively......Open My Acct process terminated!........");
        } else if (finalResponse.contains("GOOGLE")) {
            log.log("User Exist in Database with GOOGLE Social Account and "
                    + "Cannot Sign Up Natively......Open My Acct process terminated!........");
        } else if (finalResponse.contains("STILL DOES NOT EXIS")) {
            log.log("CANNOT continue process as COUNTRY or COUNTY specified STILL DO NOT exist on list, ..pls contact Customer support");
        } else if (finalResponse.contains("Disabled state")) {
            log.log("Button is in Disabled state.....Profile was "
                    + "NOT updated as NO Update was made.....");
        } else if (finalResponse.contains("Successfully")) {
            log.log("Profile was Successfully updated");
        } else if (finalResponse.contains("NOT updated")) {
            log.log("Profile was NOT updated.... pls contact Gigya customer service......");
        } else if (finalResponse.contains("MY ACCOUNT page")) {
            log.log("MY ACCOUNT page Successfully Opened and updated as expected.......");
        }
        callMethod.close();
    }
}