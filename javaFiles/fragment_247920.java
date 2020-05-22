boolean present = false;
String pageName = driver.getTitle();
if(pageName.equals("Gmail: Email from Google")){
    present = true;
} 

Assert.assertTrue(present, "Error during loading of Landing Page");