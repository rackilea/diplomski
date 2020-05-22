@Test(dependsOnMethods = { "testHomePage" }, groups = { "main_feature" })
    public void testProfilePicture () {
        flow.ValidateProfilePic(); //we do assertion to find picture section is available

// Call logout function here.
    }