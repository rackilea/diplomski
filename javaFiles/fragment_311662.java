for(int j=0; j<totalRows; j++){
         cell = sheet.getRow(j).getCell(0); 
        //Radio Button element 
         List<WebElement> elmnt = driver.findElements(By.xpath("//div[text()[contains(.,'')]]/input"));
         //It returns Entire Div Text  
         String[] parts =driver.findElement(By.xpath("//input[@name='product']/parent::div")).getText().split(" ");

         for (int i=1;i<parts.length;i++)
             {
                    System.out.println(parts[i]);
                    //Verifying cell value here.
                    if(parts[i].trim().equalsIgnoreCase(cell.getStringCellValue()))
                    {
                        elmnt.get(i-1).click();
                    }

              }

         }