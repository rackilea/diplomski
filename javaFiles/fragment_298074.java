package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DemoApplication.class)
public class MyGatewayIT {

    @Autowired
    MyGateway myGateway;

    @Test
    public void test() {
        myGateway.send(new Object());

        // do your assertions here
    }

}