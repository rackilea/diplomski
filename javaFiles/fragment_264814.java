package com.rationaleemotions.stackoverflow.qn46323434;

import org.testng.annotations.Test;

public class MyFirstTestCase extends MyBaseClass {

    @Test
    public void testGooglePage() {
        launchPage("http://www.google.com");
    }

    @Test
    public void testFaceBookPage() {
        launchPage("http://www.facebook.com");
    }
}

package com.rationaleemotions.stackoverflow.qn46323434;

import org.testng.annotations.Test;

public class MySecondTestCase extends MyBaseClass {

    @Test
    public void testHerokkuPage() {
        launchPage("https://the-internet.herokuapp.com/");
    }

    @Test
    public void testStackOverFlowPage() {
        launchPage("http://stackoverflow.com/");
    }
}