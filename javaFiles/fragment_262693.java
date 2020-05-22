@Then("^the \"([^\"]*)\" should open$")
public void verifyOnExpectedPage(String expectedPage) {
    switch (expectedPage) {
       case "shipping page":
          verifyShippingPage();
          break;  
       case "otherpage":  
          verifyOtherPage();
          break;
  }