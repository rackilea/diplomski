@Then("All my datas are correct")
public void verifyMyDatas(){

  SoftAssertions softAssertion = new SoftAssertions();

  int[] myDataArray = new int[] {1,2,3,4};
  for(int i = 0; i < myDataArray.length; i++) {
    myAwesomeValidator(myDataArray[i], softAssertion); 
  }

  softAssertion.assertAll();
}

public void myAwesomeValidator(int value, SoftAssertions softAssertion){

  // use as() to describe the assertion 
  softAssertion.assertThat(value)
               .as("awesomely validate value %d", value);
               .isLessThan(3);
}