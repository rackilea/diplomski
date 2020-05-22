element = driver.findElement(By.xpath(".//*[@id='hp_category_tab_electronics_0-content']/div[1]/div/div/a[2]"));
element.click();
for(int i=0;i<4;i++);{
        Thread.sleep(500);
        element.click();
    }