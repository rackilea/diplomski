package com.mycompany.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationContextProviderTest {

    @Autowired // Injected by Spring when bean is "ready"
    ApplicationContextProvider contextProvider;


    @Test
    public void testContext() {
        assertNotNull(contextProvider);
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();
        assertNotNull(context);

        System.out.println("My context has " + context.getBeanDefinitionCount() + " beans");
    }
}