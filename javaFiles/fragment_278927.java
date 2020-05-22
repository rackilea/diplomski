try{
 Assert.assertEquals(securityQuestionPage.UserName.getText().toString(),BaseClass.unsuccessfulpassword);  

// Now if the above line is correct then flow will not go to catch block followed by line just after this line.
 test.pass("passed",takeScreenshot)
}

catch(Exception e){
    test.fail("description", takescreenshot)
 }