package org.nkl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:/org/nkl/test-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyTest {

    @Autowired
    private Bean bean;

    @Test
    public void testPropertyPlaceholderConfigurer() {
        assertNotNull(bean);
        assertEquals("fred", bean.getName());
    }
}