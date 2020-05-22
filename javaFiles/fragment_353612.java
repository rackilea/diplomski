WebElement searchOption = driver.findElement(By.id("MainContent_DropDownQueryField")); 

    Select searchIATA = new Select(searchOption); 

    WebElement selected_value = searchIATA.getFirstSelectedOption();
    System.out.println("Selected values is "+ selected_value.getText());

    Thread.sleep(2500);
    searchIATA.selectByValue("IATA");
    Thread.sleep(2500);
    System.out.println(searchIATA.getFirstSelectedOption().getText());

    if (searchIATA.getFirstSelectedOption().getText().trim().equals("IATA"))
    {
        System.out.println("Succesfully selected IATA.");
    }
    else
    {
         System.out.println("Selected values is not IATA, it is: "+ selected_value.getText());
    }
}