package com.rationaleemotions.stackoverflow.qn48399410;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SampleTestClass {
    private int iteration;

    @Factory(dataProvider = "dp")
    public SampleTestClass(int iteration) {
        this.iteration = iteration;
    }

    @Test
    public void firstTest() {
        System.err.println("firstTest() running for iteration #" + iteration);
    }

    @Test
    public void secondTest() {
        System.err.println("secondTest() running for iteration #" + iteration);
    }

    @Test
    public void thirdTest() {
        System.err.println("thirdTest() running for iteration #" + iteration);
    }

    @DataProvider(name = "dp")
    public static Object[][] getData() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }
}