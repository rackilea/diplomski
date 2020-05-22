package com.test.testng;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

public class Calculator {

    @Test(dataProvider = "dp")
    public void add(int first, int second) {
        System.out.println("invoked add");
    }

    @Test(dataProvider = "dp")
    public void subtract(int first, int second) {
        System.out.println("invoked subtract");
    }

    @DataProvider(name = "dp")
    public Object[][] createData(Method m, ITestContext ctx) {    
        Object[][] data = new Object[][] { new Object[] { 1, 2 }, new Object[] { 2, 3 }, new Object[] { 3, 4 } };
        for (XmlClass test : ctx.getCurrentXmlTest().getXmlClasses()) {
            for (XmlInclude method : test.getIncludedMethods()) {

                if (method.getName().equals(m.getName())) {
                    int key = Integer.parseInt(method.getAllParameters().get("data-id"));
                    System.out.println("Running method " + m.getName() + "  with data-id: " + key);
                    return new Object[][] { data[key - 1] };
                }


            }
        }
        return null ;
    }

}