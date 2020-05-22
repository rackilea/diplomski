private static n0_attamp = 0;
public void testBadCredentials() throws Exception {
n0_attamp++;
RestClientFactoryTest.setPrefixAllInstances("login-failure");
XMLRPCFactoryTest.setPrefixAllInstances("login-failure");
mSolo.enterText(0, "test"); //username 
mSolo.enterText(1, "test"); //password
mSolo.clickOnText(mSolo.getString(R.string.sign_in));
boolean errorMessageFound = mSolo.searchText(mSolo.getString(R.string.username_or_password_incorrect));
if(n0_attamp = 3)
{ 
  assertTrue("3rd try", errorMessageFound);
  //reinitialize counter
   n0_attamp = 0; 
 }
 else
assertTrue("Error message not found", errorMessageFound);
}