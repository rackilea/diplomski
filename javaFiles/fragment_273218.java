boolean flag = false;
 List<WebElement> list = WebDriverFactory.getWebDriver().findElements(By.xpath(".//*[@id='paymentFormsTable']//tbody//tr"));
 int size = list.size();
 String[] actual = new String[size]; 
 String[] sorted = new String[size];

 for (int i = 0; i < size; i++) 
 {
    actual[i]=sorted[i] = WebDriverFactory.getWebDriver().findElement(By.xpath(".//[@id='paymentFormsTabl']//tbody//tr[" + i+ "]//td[starts-with(@id,'payment-forms-form-name')]")).getText();
 }

 //Sorting the array
 Arrays.sort(sorted);

 //Validating the existing with sorted array. shows no message if both are same
 for(int i = 0;i<size;i++)
 {
     if(!actual[i].equals(sorted[i]))
     {
         System.out.println("The elements the webpage are not sorted");
         System.out.println("expected "+sorted[i]+" but actual "+actual[i]+" at row "+i);
         flag = true;
     }
 }