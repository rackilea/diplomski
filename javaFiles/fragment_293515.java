int x=95, y=100;
    for(int z=1; z <=15; z++){

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(""+x);
        driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys(""+y);
        Select mark2 = new Select(driver.findElement(By.xpath("//select[@id='gradeSelector']")));
        //mark2.selectByValue(""+z);
        mark2.selectByIndex(z);
        driver.findElement(By.xpath("//input[@value='Add']")).click();

        x=x-6;
        y=y-6;
    }