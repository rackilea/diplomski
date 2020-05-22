import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "applicationContext.xml" })
@WebAppConfiguration
public class FacadeTest {

    private String phoneNumber = "111111115";

    @Autowired 
    private BussinesDelegate bussinesDelegate;

    @Test
    public void runTest(){
        this.fullTest(phoneNumber, "aaaaa");
    }

    public void fullTest(String phoneNumber, String answer){
        try {
            bmoaBussinesDelegate.processMessage("127.0.0.1", phoneNumber, "camicase" + System.currentTimeMillis());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }