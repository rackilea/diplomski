package com.sandbox;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SandboxTest {


    @Test
    public void testInputEqualsOutput() {
        String input = "S1+2S2\n" +
                "S2\n" +
                "2S3+S4\n" +
                "S1+S2";
        String output = processInput(input);
        assertEquals("1 2\n" +
                "2\n" +
                "3 4\n" +
                "1 2", output);
    }

    private String processInput(String input) {
        return input.replaceAll("\\d?S", "").replaceAll("\\+", " ");
    }

}