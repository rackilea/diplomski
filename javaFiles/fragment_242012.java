List<WebElement> radioButtons = this.getWrappedDriver().findElements(By.name("PlaceOfResidence")); 
int size = radioButtons.size();
// This is the count of total radio button

for(WebElement radio : radioButtons) 
 {
  If(radio.isSelected())
   {
     String  selectedValue =radio.findElement(By.xpath("./parent::label")).getText();
    }
  }