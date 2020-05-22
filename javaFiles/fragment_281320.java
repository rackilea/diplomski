package crea;

import org.junit.Assert;
import org.junit.Test;

import pack.Addition;

public class AdditionTest
{
    @Test
    public void test5s()
    {
        int b = 5;
        for (int a = 10; a < 20; ++a)
            Assert.assertEquals(a + b, Addition.add(a, b));
    }

    @Test
    public void test6s()
    {
        int b = 6;
        for (int a = 10; a < 20; ++a)
            Assert.assertEquals(a + b, Addition.add(a, b));
    }

    @Test
    public void test2s()
    {
        int b = 2;
        for (int a = 10; a < 20; ++a)
            Assert.assertEquals(a + b, Addition.add(a, b));
    }

    @Test
    public void test8s()
    {
        int b = 8;
        for (int a = 10; a < 20; ++a)
            Assert.assertEquals(a + b, Addition.add(a, b));
    }
}