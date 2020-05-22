public void enterFromDate(String fromDate) throws InterruptedException
{
     // Split the data and store it in string array
     String[]  data = fromDate.split(" ");

     // click datepicker icon
     fromDateCalenderIcon.click();
     // Click date picker header, It moves to month list
     calenderHeader.click();
     // Again click date picker header, It now moves to Year listing
     calenderHeader.click();


     mainloop: while(true)
     {
         //Iterate all year
         for(int i=0;i<datePickerData.size();i++)
         {
             // check weather year available in list if yes then select it 
             if(datePickerData.get(i).getText().trim().contains(data[2]))
             {

                 datePickerData.get(i).click();     
                 break mainloop;                     
             }
         }
          // else click back arrow 
         datePickerLeftArrow.click();
     }

     // Iterate month list
     for(WebElement e: datePickerData)
     {
         // If months available then click on it 
         if(e.getText().equals(data[1]))
         {
             e.click();
             break;
         }
     }

     // Iterate Date and select as required 
     for(WebElement e: datePickerData)
     {
         if((e.getText().equals(data[0]) && (e.findElement(By.tagName("span"))).getAttribute("class").equals("ng-binding")))
         {
             e.click();
             break;
         }
     }
}