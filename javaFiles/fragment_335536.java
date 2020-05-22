package com.rationaleemotions.stackoverflow.qn46224926;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    @Parameters("name")
    public void testMethod(String name) {
        System.err.println("Hello " + name);
    }
}