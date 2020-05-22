for (int i=1; i<= sheet.getLastRowNum(); i++){
        String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }