package com.mycompany.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class WsVehicleServiceTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void getHistoryAlarmInfo() throws Exception {
        try {
            WsVehicleService vehicleService = (WsVehicleService) ctx
                    .getBean("wsVehicleService");
            String hi = vehicleService.sayHi();
            System.out.println(hi);
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}