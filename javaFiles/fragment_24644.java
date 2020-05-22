package com.syz.test01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@org.junit.runner.RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class AppTest{
    @Autowired
    public App app;

    public App getApp() {
        return app;
    }
    public void setApp(App app) {
        this.app = app;
    }
    @org.junit.Test
    public void testIOC() {
        System.out.println(app);
        System.out.println(app.getPerson().getName());
    }
}