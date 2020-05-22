package com.johanw.stackoverflow.dynamicinit.init;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class PopulateObjects {
    private String[] exampleRow = { "name", "street", "10"};

    @Test
    public void method1() {
        MyObjectImpl o = PopulateObjects1.retrieveWithValues(exampleRow);
        Assert.assertTrue(o.getName().equals("name"));
        Assert.assertTrue(o.getStreet().equals("street"));
        Assert.assertTrue(o.getNumber() == 10);
        System.out.println(o);
    }

    @Test
    public void method2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MyObjectImpl o = PopulateObjects2.retrieveWithValues(exampleRow);
        Assert.assertTrue(o.getName().equals("name"));
        Assert.assertTrue(o.getStreet().equals("street"));
        Assert.assertTrue(o.getNumber() == 10);
        System.out.println(o);
    }
}