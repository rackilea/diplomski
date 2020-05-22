try{
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
            }
            catch(NoAlertPresentException e)
            {
                    //
            }