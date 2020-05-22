List<WebElement> list_Items=driver.findElements(By.xpath("//select[@id='form1:PartialSysAdminKey_adminContractIdField']/option"));
        if(list_Items.size()>1){
            System.out.println("Drop down has at least one value present");
        }
        else{
            System.out.println("No options in the drop down");
        }