if(!driver.findElements(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[3]/div[2]/div")).isEmpty()){

//Clicking on button2, which appears when button1 is not present
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[3]/div[2]/div")));

                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[3]/div[2]/div")).click();

        }

        else if(driver.findElement(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[2]/div/a/div")).isEnabled() ){

//clicking on button1
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[2]/div/a/div")));

        driver.findElement(By.xpath("//*[@id='product_container_1']/div[2]/div[2]/div[3]/div[2]/div/a/div")).click();


    }
    else
        {
            System.out.println("No such button found");
        }
        Thread.sleep(5000);