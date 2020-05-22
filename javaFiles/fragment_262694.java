@Then("^the (shipping page|other page) should open$")
public void verifyOnExpectedPage(String expectedPage) {
    switch (expectedPage) {
       case "shipping page":
          verifyShippingPage();
          break;  
       case "otherpage":  
          verifyOtherPage();
          break;
       default:
           System.out.println("Unexpected page type");  
  }