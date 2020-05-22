package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.junit.Assert.assertNotNull;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuperHero.class)
public class SMSActionPresaInCaricoTest {

    @Test
    public void testExecute() {
        PowerMockito.mockStatic(SuperHero.class);
        when(SuperHero.findSuperHero(anyString())).thenReturn(new SuperHero());
        assertNotNull(SuperHero.findSuperHero("Batman"));
    }
}