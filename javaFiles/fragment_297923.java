driver.findElement(By.id("van")).getAttribute("value"); 

// please note when you want 
to check the value entered by you inside the input box then do not use getText() 
as it returns inner visible html of the tag
So to get the value there is a hidden attribute for every input box known as "value" 
which keeps value entered by you.