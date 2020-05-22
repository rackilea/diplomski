package com.richashworth.powermockexample;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)
@PrepareForTest({DataProvider.class})
public class ResultsWriterTest {

    private static List<String> mockData = new ArrayList<String>();
    private ResultsWriter resultsWriter;

    @BeforeClass
    public static void setUpOnce() {
        final String firstLine = "Line 1";
        final String secondLine = "Line 2";
        mockData.add(firstLine);
        mockData.add(secondLine);
    }

    @Before
    public void setUp() {
        resultsWriter = new ResultsWriter();
    }

    @Test
    public void testGetDataAsString() throws Exception {
        PowerMockito.spy(DataProvider.class);
        PowerMockito.doReturn(mockData).when(DataProvider.class, "readFile");

        final String expectedData = "Line 1\nLine 2\n";
        final String returnedString = resultsWriter.getDataAsString();

        assertEquals(expectedData, returnedString);
    }

}