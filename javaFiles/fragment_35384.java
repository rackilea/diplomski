SoftAssert softAssert = new SoftAssert();
String ActualErrorMEssage = firstNameerrorXpath.getText;
String ActualErrorMEssage2 = secondNameNameerrorXpath.getText;
softAssert.assertEquals(ActualErrorMEssage,ExpectedErrorMEssage);
softAssert.assertEquals(ActualErrorMEssage2,ExpectedErrorMEssage);
softAssert.assertAll();