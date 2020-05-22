your unitTest()
{
 try {
  // make a call to the method you want to test
    yourMethod.call(inputToAllowException);
    Assert.assertEquals(1 , 0); // you should not reach here if the exception was thrown
 } catch(YourException ye)
 {
  //assertion or print to say exception was thrown
 }
}